package tooltwist.jay.widgets;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.Navpoint;
import tooltwist.wbd.PageImportCodeInserter;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdCache;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdSession;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import tooltwist.wbd.WbdWidgetController;
import tooltwist.wbd.WbdProductionHelper;
//import tooltwist.jay.productionHelpers.MenuSideProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Menu Side Navi
 */
public class MenuSideWidget extends WbdWidgetController
{
	private static final String SNIPPET_PREVIEW = "menuSide_preview.html";
	private static final String SNIPPET_DESIGN = "menuSide_design.html";
	private static final String SNIPPET_PRODUCTION = "menuSide_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = false;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
//		instance.defineProperty(new WbdStringProperty("myProperty", null, "My Property", ""));
//		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
	}
	
	@Override
	public void getCodeInserters(WbdGenerator generator, WbdWidget instance, UimData ud, CodeInserterList codeInserterList) throws WbdException
	{
//TODO: Uncomment this as required
		GenerationMode mode = generator.getMode();
		if (mode == GenerationMode.DESIGN)
		{
			// Add code inserters for design mode
			CodeInserter[] arr = {

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "menuSide_cssHeader.css")),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PREVIEW)
		{
			// Add code inserters for preview mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),

//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),

//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "menuSide_jsHeader.js")),

				// Include a CSS snippet
				//new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "menuSide_cssHeader.css")),
				new StylesheetCodeInserter(generator, instance, "menuSide_cssHeader.css"),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PRODUCTION || generator.getMode() == GenerationMode.CONTROLLER)
		{
			// Add code inserters for production mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),
					
//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),
					
//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "menuSide_jsHeader.js")),
					
				// Include a CSS snippet
			//	new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "menuSide_cssHeader.css")),
				new StylesheetCodeInserter(generator, instance, "menuSide_cssHeader.css"),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
//				codeInserterList.add(WbdProductionHelper.codeInserter(instance, MenuSideProductionHelper.class.getName(), productionHelperParams));
//				codeInserterList.add(new PageImportCodeInserter(MenuSideProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "Menu Side Navi";
	}
	
	@Override
	public WbdSizeInfo getSizeInfo(WbdGenerator generator, WbdWidget instance) throws WbdException
	{
		return WbdSizeInfo.unknownSizeInfo();
	}
	
	@Override
	public void renderForPreview(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_PREVIEW, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForDesigner(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_DESIGN, getSnippetParams(generator, instance, ud));
	}
	
	public void test(WbdRenderHelper rh) {
		
	}
	
	public void test(String rh) {
		
	}
	
	@Override
	public void renderForJSP(WbdGenerator generator, WbdWidget instance, UimHelper ud, WbdRenderHelper rh) throws Exception
	{
		
		String str = "";
		
	//	rh.beforeProductionCode(generator, instance, getSnippetParams(generator, instance, ud), USE_PRODUCTION_HELPER);
	//	rh.renderSnippetForProduction(generator, instance, SNIPPET_PRODUCTION);
	//	rh.afterProductionCode(generator, instance);
		
		rh.append("<div id='cssmenu'>");
		rh.append("<ul>");
		
		//getting the navpoint id status if it is active or not
		String navpointId = WbdSession.getNavpointId(ud.getCredentials());
		
		//find navpoint to get the navpoint property
		Navpoint navPoint = WbdCache.findNavPoint("jay-14", true);
		
		//<> = arraylist initiation to get all the navpoint child
		Iterable<Navpoint> children = navPoint.getChildren();
		
		for(Navpoint nav: children) {
			
				String label = nav.getLabel();
				// /ttsvr/n/Home/training-1
				String myLink = RoutingUIM.navpointUrl(ud, nav.getId(), AutomaticUrlParametersMode.NO_AUTOMATIC_URL_PARAMETERS);

				String classActive = "";
				
				//condition for the getting the navpoint ID (current page id)
				if (navpointId.equals(nav.getId()))// navpointId == nav.getID
					classActive  = "active";
				
				
				rh.append("<li class='"+classActive+"'><a href="+myLink+"><span>"+label+"</span></a>");
				//rh.append("<li class=''><a href="+myLink+"><span>"+label+"</span></a>");
				
				if (nav.hasChildren(true))// navpointId == nav.getID)//1sst dfdfjdsfsd 
					rh.append("<ul>");
				
				Iterable<Navpoint> childrensub = nav.getChildren();
				
				//checing for the first child navpoint
				for(Navpoint navsub: childrensub) {
					String labelsub = navsub.getLabel();
					// /ttsvr/n/Home/training-1
					String myLinksub = RoutingUIM.navpointUrl(ud, navsub.getId(), AutomaticUrlParametersMode.NO_AUTOMATIC_URL_PARAMETERS);
					
					//getting the navpoint id status if it is active or not
					//String navpointId= WbdSession.getNavpointId(ud.getCredentials());
					//if(classActive == "active")
					if (navpointId.equals(nav.getId())) { // navpointId == nav.getID
						rh.append("<li class='has-sub'><a href="+myLinksub+"><span>"+labelsub+"</span></a>");
					}
					Iterable<Navpoint> childrensubtwo = navsub.getChildren();
					
					
					rh.append("<ul>");
					// checking for the 2nd sub child navpoint
					for(Navpoint navsubtwo: childrensubtwo) {
						String labelsubtwo = navsubtwo.getLabel();
						// /ttsvr/n/Home/training-1
						String myLinksubtwo = RoutingUIM.navpointUrl(ud, navsubtwo.getId(), AutomaticUrlParametersMode.NO_AUTOMATIC_URL_PARAMETERS);
						
					
						//getting the navpoint id status if it is active or not
						String navpointIdsub = WbdSession.getNavpointId(ud.getCredentials());
						if (navpointIdsub.equals(navsubtwo.getId()))// navpointId == nav.getID to check if i
						rh.append("<li><a href="+myLinksubtwo+"><span>"+labelsubtwo+"</span></a></li>");
						
						
						
					}
					rh.append("</li>");
					rh.append("</ul>");
					}
					
				
				if (nav.hasChildren(true))
					rh.append("</ul>");
				
		rh.append("</li>");
		}
		rh.append("</ul");
		rh.append("</div>");
	}
		
	
	
	private SnippetParam[] getSnippetParams(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
//		String myProperty = instance.getProperty("myProperty", null);
//		String myNavpoint = instance.getProperty("myNavpoint", null);
		SnippetParam[] params = {
//			new SnippetParam("myProperty", myProperty),
//			new SnippetParam("myNavpoint", myNavpoint)
		};
		return params;
	}
}
