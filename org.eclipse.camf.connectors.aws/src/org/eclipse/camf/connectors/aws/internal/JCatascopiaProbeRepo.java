package org.eclipse.camf.connectors.aws.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JCatascopiaProbeRepo {
    
    private static final String DEFAULT_REPO_HOST = "https://api.github.com/";
    private static final String DEFAULT_REPO = "JCatascopia-Probe-Repo";
    private static final String DEFAULT_OWNER = "dtrihinas";
    
    private String repo;
    private String owner;
    private String initURL;
    
    JCatascopiaProbeRepo(String repo, String owner) {
        this.repo = repo;
        this.owner = owner;
        this.initURL = DEFAULT_REPO_HOST + "repos/" + this.owner + "/" + this.repo;
    }
    
   public JCatascopiaProbeRepo() {
        this(DEFAULT_REPO, DEFAULT_OWNER);
    }
    
    public String getProbes() throws JCatascopiaProbeRepoException {
        String probeList = null;
        try{
            String lastCommit = this.getLastCommit();
            probeList = getProbeList(lastCommit);
        }
        catch (Exception e){
            throw new JCatascopiaProbeRepoException("Fail to retrieve available JCatascopia Probes");
        }
        
        return probeList;
    }
    
    private String getProbeList(String sha){
        JSONArray probeList = new JSONArray();
        try{
            String raw = this.getURLResponse(this.initURL + "/git/trees/" + sha + "?recursive=1");
            JSONArray arr = new JSONObject(raw).getJSONArray("tree");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                String p = obj.get("path").toString();
                if (p.contains(".probe")) {
                    String probe = this.getProbeJSON(p);
                    if (probe != null)
                        probeList.put(new JSONObject(probe));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            probeList = null;
        }
        return probeList.toString();
    }
    
    private String getProbeJSON(String path) {
        String resp = null;
        try{
            resp = this.getURLResponse("https://raw.githubusercontent.com/" + this.owner + "/" + this.repo + "/master/" + path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    private String getLastCommit(){
        String resp = null;
        try{
            String raw = this.getURLResponse(this.initURL + "/commits");
            resp = new JSONArray(raw).getJSONObject(0).getJSONObject("commit").getJSONObject("tree").get("sha").toString(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    private String getURLResponse(String url) { 
        String resp = null;
        try{    
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");       
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            if(conn.getResponseCode() == 200){
                while ((line = in.readLine()) != null)
                    sb.append(line);
                resp = sb.toString();
            }
                    
            return resp;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }       
    }
    
    public static void main(String[] args) throws JCatascopiaProbeRepoException {
        JCatascopiaProbeRepo repo;
        if (args.length >= 2)
            repo = new JCatascopiaProbeRepo(args[0],args[1]);
        else
            repo = new JCatascopiaProbeRepo();
        System.out.println(repo.getProbes());
    }
}
