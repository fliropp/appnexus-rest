package no.amedia.appnexus.appnexusrest;

import no.amedia.appnexus.appnexusrest.model.appnexus.template.CreativeTemplate;
import no.amedia.appnexus.appnexusrest.model.appnexus.template.Macro;
import no.amedia.appnexus.appnexusrest.service.AppnexusAuth;
import no.amedia.appnexus.appnexusrest.service.AppnexusRest;
import no.amedia.appnexus.appnexusrest.service.Format;
import no.amedia.appnexus.appnexusrest.service.MediaSubType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppnexusRestApplicationTests {


	private AppnexusRest service = new AppnexusRest();
	private AppnexusAuth authService = new AppnexusAuth();

	@Before
	public void setup() {
		authService.authorize();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTemplate() {
		authService.authorize();
		service.createTemplate(sprayAdBasic, getMacros());

	}

	@Test
	public void updateTemplateJavascript() {
		String js = "${CONTENT}";
		service.updateTemplate("40690", js, Format.Type.RAW_JS, MediaSubType.Type.BANNER, null);
	}

	@Test
	public void updateTemplateHtml() {
		service.updateTemplate("40690", sprayAdBasic, Format.Type.RAW_HTML, MediaSubType.Type.BANNER, null);
	}

	@Test
	public void getTempl8() {
		CreativeTemplate tmpl = service.getTemplate(Integer.toUnsignedLong(40690));
		System.out.println(tmpl.getContent_html());
	}

	private ArrayList<Macro> getMacros() {
		ArrayList<Macro> macros = new ArrayList<Macro>();
		macros.add(new Macro( "#{ADUNIT}", "adunit", "string", true, null, null));
		macros.add(new Macro( "#{CLICK_URL_UNESC}", "click_url_unesc", "string", true, null, null));
		macros.add(new Macro( "#{DEST_URL}", "destination url", "string", true, null, null));
		macros.add(new Macro( "#{IMAGE}", "image", "string", true, null, null));
		macros.add(new Macro( "#{LABEL}", "label", "string", true, null, null));
		macros.add(new Macro( "#{LONGTITLE}", "longtitle", "string", true, null, null));
		macros.add(new Macro( "#{SHORTTITLE}", "shorttitle", "string", true, null, null));
		macros.add(new Macro( "#{UTM_CAMPAIGN}", "utm campaign", "string", true, null, null));
		macros.add(new Macro( "#{UTM_MEDIUM}", "utm medium", "string", true, null, null));
	    return macros;
	}



	String mockAd = "${CONTENT}<div><h1>#{ADUNIT}</h1><h2>#{CLICK_URL_UNESC}</h2><h3>#{DEST_URL}</h3>" +
			"<p>#{LABEL}</p><p>#{LONGTITLE}</p><p>#{SHORTTITLE}</p><p>#{UTM_CAMPAIGN}</p><p>#{UTM_MEDIUM}</p></div>";

	String sprayAdBasic = "<div id='cm-content'>\n" +
			"  <a id=\"cm-url\" href=\"#\" target=\"_blank\">\n" +
			"\t\t<article>\n" +
			"\t\t\t<div id=\"img-container\" class=\"cm-img\">\n" +
			"\t\t\t\t<span class=\"cm-label\"></span>\n" +
			"                \n" +
			"                <img \n" +
			"\t\t\t\t    srcset=\"https://pbx.images.nettavisen.no/?url=#{IMAGE}&w=1024&h=550&mode=crop 1024w,\n" +
			"\t\t\t\t    \t\thttps://pbx.images.nettavisen.no/?urr=#{IMAGE}&w=800&h=430&mode=crop 800w,\n" +
			"\t\t\t\t    \t\thttps://pbx.images.nettavisen.no/?url=#{IMAGE}&w=600&h=320&mode=crop 600w\" \n" +
			"\t\t\t\t\tsizes=\"100vw\" \n" +
			"\t\t\t\t\tclass=\"main-img\" \n" +
			"\t\t\t\t\talt=\"\"\n" +
			"\t\t\t\t>\n" +
			"\t\t\t</div>\n" +
			"\t\t\t\n" +
			"\t\t\t<h1 class=\"resize\"></h1>\n" +
			"\t\t</article>\n" +
			"\t</a>\n" +
			"\n" +
			"\n" +
			"\t<script src='https://cdn.rawgit.com/scottjehl/picturefill/3.0.2/dist/picturefill.js'></script>\n" +
			"<script src='https://services.snap1.api.no/api/bazaar/assets/v2/spray.js'></script>\n" +
			"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://services.snap1.api.no/api/bazaar/assets/spray.css\" media=\"screen\" />" +
			"\n" +
			"\t<script>\n" +
			"    \t\n" +
			"\n" +
			"\n" +
			"\t\twindow.onload = function(){\n" +
			"\t\t    spray.adjustContent('#{ADUNIT}', '#{LONGTITLE}', '#{SHORTTITLE}', '#{LABEL}', '#{CLICK_URL_UNESC}', '#{DEST_URL}', '#{UTM_MEDIUM}', '#{UTM_CAMPAIGN}');\n" +
			"\t\t};\n" +
			"\t</script>\n" +
			" </div>";

	String sprayAd =
			"${CONTENT}<div id='cm-content'>\n" +
			" <style>\n" +
			"\t@import url('https://fonts.googleapis.com/css?family=Open+Sans:600,700');\n" +
			"\t*{\n" +
			"\tmargin: 0;\n" +
			"\tpadding: 0;\n" +
			"\toutline: none;\n" +
			"\t}\n" +
			"\t*, *:before, *:after{\n" +
			"\t-webkit-box-sizing: border-box;\n" +
			"\t-moz-box-sizing: border-box;\n" +
			"\tbox-sizing: border-box;\n" +
			"\t}\n" +
			"\tbody {\n" +
			"\tfont-family: 'Open Sans', sans-serif;\n" +
			"\t}\n" +
			"\t#cm-content{\n" +
			"\theight: 0;\n" +
			"\twidth: 100%;\n" +
			"\tpadding-bottom: 100%;\n" +
			"\t}\n" +
			"\t#cm-content #img-container{\n" +
			"\tposition: relative;\n" +
			"\t}\n" +
			"\t#cm-content #img-container img{\n" +
			"\tvertical-align: middle;\n" +
			"\t}\n" +
			"\t#cm-content #img-container .cm-label{\n" +
			"\tdisplay: block;\n" +
			"\tposition: absolute;\n" +
			"\tbottom: 10px;\n" +
			"\tleft: 10px;\n" +
			"\tbackground-color: #f4cf3e;\n" +
			"\tpadding: 1.5% 2%;\n" +
			"\tcolor: #292827;\n" +
			"\tfont-weight: 700;\n" +
			"\tfont-size: 15px;\n" +
			"\tline-height: 15px;\n" +
			"\ttext-transform: uppercase;\n" +
			"\t}\n" +
			"\t#cm-content h1{\n" +
			"\tfont-size: 120px;\n" +
			"\tline-height: 1;\n" +
			"\twidth: 100%;\n" +
			"\tpadding: 4px 4px 0;\n" +
			"\tfont-weight: 600;\n" +
			"\tword-wrap: break-word;\n" +
			"\toverflow-wrap: break-word;\n" +
			"\t}\n" +
			"\t#cm-content a{\n" +
			"\tcolor: #000;\n" +
			"\ttext-decoration: none;\n" +
			"\t}\n" +
			"\t#cm-content a:hover, #cm-content a:hover h1{\n" +
			"\ttext-decoration: none;\n" +
			"\t}\n" +
			"\t@media only screen and (min-width: 980px){\n" +
			"\t#cm-content{\n" +
			"\tpadding-bottom: 280px;\n" +
			"\t}\n" +
			"\t#cm-content article::after{\n" +
			"\tcontent: '.';\n" +
			"\tvisibility: hidden;\n" +
			"\tdisplay: block;\n" +
			"\theight: 0;\n" +
			"\tclear: both;\n" +
			"\t}\n" +
			"\t#cm-content\tarticle #img-container{\n" +
			"\tfloat: left;\n" +
			"\tmargin-right: 20px;\n" +
			"\theight: 280px;\n" +
			"\t}\n" +
			"\t#cm-content article #img-container img{\n" +
			"\theight: 280px;\n" +
			"\t}\n" +
			"\t#cm-content article h1{\n" +
			"\twidth: 460px;\n" +
			"\tfloat: right;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t@media only screen and (min-width: 380px) and (max-width: 480px){\n" +
			"\t#cm-content\t#img-container .cm-label{\n" +
			"\tfont-size: 2.7vw;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t@media only screen and (max-width: 379px){\n" +
			"\t#cm-content\t#img-container .cm-label {\n" +
			"\tfont-size: 3.3vw;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t@media only screen and (max-width: 300px){\n" +
			"\t#cm-content #img-container .cm-label{\n" +
			"\tfont-size: 3.7vw;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t@media only screen and (max-width: 200px){\n" +
			"\t#cm-content #img-container .cm-label{\n" +
			"\tfont-size: 4.3vw;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen{\n" +
			"\twidth: 100%;\n" +
			"\t/* fix */\n" +
			"\tpadding: 0;\n" +
			"\theight: auto;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container{\n" +
			"\tposition: relative;\n" +
			"\tbackground-color: #CFCFCF;\n" +
			"\t/* fix */\n" +
			"\tfloat: none;\n" +
			"\tmargin: 0;\n" +
			"\theight: auto;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container .cm-label{\n" +
			"\tdisplay: block;\n" +
			"\tcolor: #000;\n" +
			"\ttext-transform: uppercase;\n" +
			"\tfont-size: 12px;\n" +
			"\theight: 26px;\n" +
			"\tpadding: 5px 10px 0 10px;\n" +
			"\tdisplay: block;\n" +
			"\tfont-weight: bold;\n" +
			"\t/* fix */\n" +
			"\tposition: relative;\n" +
			"\tbottom: auto;\n" +
			"\tleft: auto;\n" +
			"\tbackground-color: transparent;\n" +
			"\tline-height: 18px;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container .cm-label:before{\n" +
			"\tcontent: '';\n" +
			"\tfloat: left;\n" +
			"\tbackground: url( '//www.nettavisen.no/templates/v1/images/handlevogn_desktop.png' ) center no-repeat;\n" +
			"\tbackground-size: 16px;\n" +
			"\twidth: 16px;\n" +
			"\theight: 16px;\n" +
			"\tmargin-right: 4px;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container .cm-label:after{\n" +
			"\tcontent: 'med annonselenker';\n" +
			"\tfloat: right;\n" +
			"\tfont-weight: 100;\n" +
			"\ttext-transform: lowercase;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container .cm-label.hide-elements:before,\n" +
			"\t#cm-content.nettavisen #img-container .cm-label.hide-elements:after{\n" +
			"\tdisplay: none;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container img{\n" +
			"\tvertical-align: middle;\n" +
			"\tpadding: 1px;\n" +
			"\twidth: 100%;\n" +
			"\t/* fix */\n" +
			"\theight: auto;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen h1{\n" +
			"\tfont-family: Georgia, 'Times New Roman', Serif;\n" +
			"\tfont-size: 120px;\n" +
			"\tline-height: 1.1;\n" +
			"\twidth: 100%;\n" +
			"\tpadding: 4px 2px 10px;\n" +
			"\tfont-weight: 600;\n" +
			"\tword-wrap: break-word;\n" +
			"\toverflow-wrap: break-word;\n" +
			"\tcolor: #000;\n" +
			"\t/* fix */\n" +
			"\tfloat: none;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen a{\n" +
			"\tcolor: #000;\n" +
			"\ttext-decoration: none;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen a:hover, a:hover h1{\n" +
			"\ttext-decoration: none;\n" +
			"\t}\n" +
			"\t@media only screen and (min-width: 380px) and (max-width: 480px){}\n" +
			"\t@media only screen and (max-width: 379px){\n" +
			"\t#cm-content.nettavisen #img-container .cm-label{\n" +
			"\t  font-size: 10px;\n" +
			"\t  height: 22px;\n" +
			"\t  padding: 5px 5px 0 5px;\n" +
			"\t}\n" +
			"\t#cm-content.nettavisen #img-container .cm-label:before{\n" +
			"\t  background-size: 12px;\n" +
			"\t  width: 12px;\n" +
			"\t  height: 12px;\n" +
			"\t  margin-right: 4px;\n" +
			"\t}\n" +
			"\t}\n" +
			"\t@media only screen and (max-width: 300px){}\n" +
			"\t@media only screen and (max-width: 200px){}\n" +
			"\t</style>\n" +
			"<a id=\"cm-url\" href=\"#\" target=\"_blank\">\n" +
			"\t\t<article>\n" +
			"\t\t\t<div id=\"img-container\" class=\"cm-img\">\n" +
			"\t\t\t\t<span class=\"cm-label\"></span>\n" +
			"                \n" +
			"                <img \n" +
			"\t\t\t\t    srcset=\"https://pbx.images.nettavisen.no/?url=#{Image}&w=1024&h=550&mode=crop 1024w,\n" +
			"\t\t\t\t    \t\thttps://pbx.images.nettavisen.no/?url=#{Image}&w=800&h=430&mode=crop 800w,\n" +
			"\t\t\t\t    \t\thttps://pbx.images.nettavisen.no/?url=#{Image}&w=600&h=320&mode=crop 600w\" \n" +
			"\t\t\t\t\tsizes=\"100vw\" \n" +
			"\t\t\t\t\tclass=\"main-img\" \n" +
			"\t\t\t\t\talt=\"\"\n" +
			"\t\t\t\t>\n" +
			"\t\t\t</div>\n" +
			"\t\t\t\n" +
			"\t\t\t<h1 class=\"resize\"></h1>\n" +
			"\t\t</article>\n" +
			"\t</a>" +
			"\t<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>\n" +
			"\t<script src='https://cdn.rawgit.com/scottjehl/picturefill/3.0.2/dist/picturefill.js'></script>\n" +
			"\t<script>\n" +
			"  \tfunction adjustContent( longTitleEdit, shortTitleEdit ) {\n" +
			" \t\t\tvar adUnit = '#{ADUNIT}';\n" +
			"      var clickUrl = '#{CLICK_URL_UNESC}#{DEST_URL}';\n" +
			"\t\t\tvar parentNettavisen = ( adUnit.indexOf( 'nettavisen.no' ) >= 0 );\n" +
			" \t\t\tvar widthBody =\t$( 'body' ).width(),\n" +
			" \t\t\t\theightBody = widthBody,\n" +
			"\t\t\t\theightImg = $( '.cm-img img' ).outerHeight(),\n" +
			"\t\t\t\tlongTitle =\t'#{LONGTITLE}',\n" +
			"\t\t\t\tshortTitle = '#{SHORTTITLE}',\n" +
			"\t\t\t\tlabel = '#{LABEL}',\n" +
			"        utm_medium = '#{UTM_MEDIUM}',\n" +
			"        utm_campaign = '#{UTM_CAMPAIGN}';\n" +
			"      if ( parentNettavisen ) {\n" +
			"  \t\t\t$( '#cm-content' ).addClass( 'nettavisen' );\n" +
			" \t\t\t}\n" +
			"      if ( label.indexOf( 'Annons' ) >= 0 ) {\n" +
			"        $( '.cm-label' ).addClass( 'hide-elements' );\n" +
			"      }\n" +
			"\t\t\tif ( !parentNettavisen && label.indexOf( 'Annons' ) <= -1 ) {\n" +
			"        $( '.cm-label' ).addClass( 'hide-elements' );\n" +
			"        label = 'Annonselenker';\n" +
			"      }\n" +
			"      // Sett korrekt label\n" +
			"\t\t\t$( '.cm-label' ).html( label );\n" +
			"\t\t\tif ( longTitleEdit ) {\n" +
			"\t\t\t\tlongTitle = longTitleEdit;\n" +
			"\t\t\t}\n" +
			"\t\t\tif ( shortTitleEdit ) {\n" +
			"\t\t\t\tshortTitle = shortTitleEdit;\n" +
			"\t\t\t}\n" +
			"\t\t\t// Resize text script\n" +
			"\t\t\tvar autoSizeText;\n" +
			"\t\t\tautoSizeText = function() {\n" +
			"\t\t\t var el, elements, _i, _len, _results;\n" +
			"\t\t\t elements = $('.resize');\n" +
			"\t\t\t if (elements.length < 0) {\n" +
			"\t\t\t  return;\n" +
			"\t\t\t }\n" +
			"\t\t\t _results = [];\n" +
			"\t\t\t for (_i = 0, _len = elements.length; _i < _len; _i++) {\n" +
			"\t\t\t  el = elements[_i];\n" +
			"\t\t\t  _results.push((function(el) {\n" +
			"\t\t\t   var resizeText, _results1;\n" +
			"\t\t\t   resizeText = function() {\n" +
			"\t\t\t    var elNewFontSize;\n" +
			"          // Minus 2px per iterasjon\n" +
			"\t\t\t    elNewFontSize = ( parseInt( $( el ).css( 'font-size' ).slice( 0, -2 ) ) - 2 ) + 'px';\n" +
			"\t\t\t    return $( el ).css( 'font-size', elNewFontSize );\n" +
			"\t\t\t   };\n" +
			"\t\t\t   _results1 = [];\n" +
			"\t\t\t   while (el.scrollHeight > el.offsetHeight) {\n" +
			"\t\t\t    _results1.push(resizeText());\n" +
			"\t\t\t   }\n" +
			"\t\t\t   return _results1;\n" +
			"\t\t\t  })(el));\n" +
			"\t\t\t }\n" +
			"\t\t\t return _results;\n" +
			"\t\t\t};\n" +
			"\t  \t// Lang eller kort tittel?\n" +
			"\t  \t$( '.resize' ).html( ( widthBody < 350 ? shortTitle : longTitle ) );\n" +
			"\t\t\tif ( !parentNettavisen && widthBody >= 980 ) {\n" +
			"\t\t\t\t// Ratio 4x3\n" +
			"\t\t\t\theightBody = ( widthBody * ( 1 - 0.25 ) );\n" +
			"\t\t\t}\n" +
			"\t\t\t// Finn tilgjengelig plass til tittelen\n" +
			"\t\t\tvar availableH1Space = heightBody - heightImg;\n" +
			"\t\t\t// Sett høyde på tittel så resize-scriptet vet rammen\n" +
			"\t\t\tif ( !parentNettavisen && widthBody >= 980 ) {\n" +
			"\t\t\t \t$( '.resize' ).css( 'height', '280px' );\n" +
			"\t\t\t} else if ( !parentNettavisen ) {\n" +
			"\t\t\t\t$( '.resize' ).css( 'height', availableH1Space - 25 + 'px' );\n" +
			"\t\t\t}\n" +
			"      var domain = adUnit.split( '/' )[2].toLowerCase();\n" +
			"      var utm_space = false;\n" +
			"      if ( clickUrl.indexOf( 'adform.net' ) >= 0 && clickUrl.indexOf( '?' ) >= 0 ) {\n" +
			"      \tutm_space = true;\n" +
			"      }\n" +
			"      if ( utm_campaign ) {\n" +
			"        clickUrl = clickUrl + ( utm_space ? '&' : '?' ) + 'utm_campaign=' + utm_campaign;\n" +
			"        utm_space = true;\n" +
			"      }\n" +
			"      if ( utm_medium ) {\n" +
			"        clickUrl = clickUrl + ( utm_space ? '&' : '?' ) + 'utm_medium=' + utm_medium;\n" +
			"        utm_space = true;\n" +
			"      }\n" +
			"      if ( domain ) {\n" +
			"        clickUrl = clickUrl + ( utm_space ? '&' : '?' ) + 'utm_source=' + domain;\n" +
			"        utm_space = true;\n" +
			"\t\t\t}\n" +
			"      if ( adUnit.split( '/' )[2] ) {\n" +
			"      \tclickUrl = clickUrl.replace( 'annonsorinnhold.nettavisen.no', domain + '/vis/annonsorinnhold' );\n" +
			"        clickUrl = clickUrl.replace( 'www.avisnavn.no', domain );\n" +
			"      }\n" +
			"      $( '#cm-url' ).attr( 'href', clickUrl );\n" +
			"\t\t\t// Resize tittel\n" +
			"\t    autoSizeText();\n" +
			"\t  }\n" +
			"\t\t$( window ).on( 'load', function() {\n" +
			"\t\t  adjustContent();\n" +
			"\t\t});\n" +
			"\t</script>\n" +
			" </div>";



}
