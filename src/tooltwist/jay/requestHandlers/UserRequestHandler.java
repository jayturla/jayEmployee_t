package tooltwist.jay.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;

import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "user" - User Request Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=jay_widgets.userMaintenance.user
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class UserRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{

		String userId = uh.getRequestValue("userId");
		String userName = uh.getRequestValue("username");
		String password = uh.getRequestValue("password");
		
		try {
			if(userId == null || userId.equals("")){
				Xpc xpc = uh.getXpc();
			    xpc.start("phinza.D.user", "insert");
			    //xpc.attrib("userId", userId);
			    xpc.attrib("username", userName);
			    xpc.attrib("password", password);
			    XData data = xpc.run();
			}else{
				
				Xpc xpc = uh.getXpc();
			    xpc.start("phinza.D.user", "update");
			    xpc.attrib("userId", userId);
			    xpc.attrib("username", userName);
			    xpc.attrib("password", password);
			    XData data = xpc.run();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
