package cy.ac.ucy.linc.CloudSoftwareRepo.Communication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;

public class CloudHttp {

	public HttpClient httpClient;
	public HttpGet httpGet;
	public HttpPost httpPost;
	public HttpEntity httpEntity;
	public HttpResponse httpResponse;
	public HttpDelete httpDelete;

	public MultipartEntityBuilder meBuilder;

	public String response;

	public CloudHttp() {
		super();
		// TODO Auto-generated constructor stub
		httpClient = HttpClientBuilder.create().build();
		meBuilder = MultipartEntityBuilder.create();
	}

	public String CloudHttpGetRequest(String url) throws RepoExceptions {
		httpGet = new HttpGet(url);
		try {
			httpResponse = httpClient.execute(httpGet);
			httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity);

			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpHostConnectException e) {
			throw new RepoExceptions("Repository unreachable at the moment");
			// System.out.println("Repository unreachable at the moment");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// httpEntity = httpResponse.getEntity();
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return response;
	}

	public String CloudHttpPostRequest(String url) throws RepoExceptions {
		httpPost = new HttpPost(url);
		HttpEntity httpEn = meBuilder.build();
		// System.out.println(meBuilder.)
		httpPost.addHeader("Authorization", "Basic " + authenticate());
		httpPost.setEntity(httpEn);
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (HttpHostConnectException e) {
			throw new RepoExceptions("Repository unreachable at the moment");
			// System.out.println("Repository unreachable at the moment");

		}catch (FileNotFoundException e) {
			throw new RepoExceptions("No such file");
			// System.out.println("Repository unreachable at the moment");

		}		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpEntity = httpResponse.getEntity();
		try {
			response = EntityUtils.toString(httpEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
		System.out.println(response);

		return response;
	}

	public String CloudHttpDeleteRequest(String url){
		
		httpDelete = new HttpDelete(url);
		httpDelete.addHeader("Authorization", "Basic " + authenticate());
		
		try {
			httpResponse = httpClient.execute(httpDelete);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response = httpResponse.getStatusLine().toString();
		
		System.out.println(response);
		return response;
		
	}
	private String authenticate() {
		// TODO Auto-generated method stub
		String encoding = new String(Base64.encodeBase64(("admin:admin123")
				.getBytes()));
		return encoding;
	}

	public void addPart(Map<String, String> parameters)
			throws UnsupportedEncodingException {
		meBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		System.out.println("Parameters: ");
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			System.out.println("Parameter: " + entry.getKey() + " Value: "
					+ entry.getValue());
			if (entry.getKey().equals("file")) {

				
				meBuilder.addPart("file",
						new FileBody(new File(entry.getValue()),
								ContentType.DEFAULT_BINARY));
			} else {
			
				
				meBuilder.addPart(entry.getKey(),
						new StringBody(entry.getValue(), ContentType.DEFAULT_TEXT));

			}
		}

	}

}
