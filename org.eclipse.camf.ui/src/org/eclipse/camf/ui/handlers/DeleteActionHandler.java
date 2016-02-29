package org.eclipse.camf.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;


public class DeleteActionHandler extends AbstractHandler implements IHandler2{

  @Override
  public Object execute( ExecutionEvent event ) throws ExecutionException {
    // TODO Auto-generated method stub
    
    System.out.println("Delete Handler invoked");
    return null;
    
  }
  

  
  @Override
  public boolean isEnabled(){
    return true;
  }
  
}
