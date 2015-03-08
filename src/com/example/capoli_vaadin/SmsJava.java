package com.example.capoli_vaadin;


import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class SmsJava
{

	 
private static String FB_APP_KEY = "012345678901234";
private static String FB_APP_SECRET = "0123456789abcdef0123456789abcdef";
 
/*
private static OAuthService getOAuthService()
{
return new ServiceBuilder()
.provider(FacebookApi.class)
.apiKey(FB_APP_KEY)
.apiSecret(FB_APP_SECRET)
.callback("http://www.smhumayun.com/")
.build();
}
 
@SuppressWarnings("UnusedDeclaration")
private static Token getFbAppShortLivedAccessToken(OAuthService oAuthService)
{
Token fbAppShortLivedAccessToken;
 
System.out.println("Fetching the Authorization URL...");
String authorizationUrl = oAuthService.getAuthorizationUrl(null);
System.out.println("Got the Authorization URL!");
 
System.out.println("Now go and authorize this program here:");
System.out.println(authorizationUrl);
System.out.println("And paste the authorization code here");
System.out.print(">>");
Verifier verifier = new Verifier(new Scanner(System.in).nextLine());
System.out.println();
 
// Trade the Request Token and Verfier for the Access Token
System.out.println("Trading the Request Token for an Access Token...");
fbAppShortLivedAccessToken = oAuthService.getAccessToken(null, verifier);
System.out.println("Got the Access Token!");
 
System.out.println("(if your curious it looks like this: " + fbAppShortLivedAccessToken + " )");
System.out.println();
 
return fbAppShortLivedAccessToken;
}
 
@SuppressWarnings("UnusedDeclaration")
private static Token getFbAppLongLivedAccessToken(OAuthService oAuthService, Token fbAppShortLivedAccessToken)
{
Token fbAppLongLivedAccessToken = null;
System.out.println("Getting the Long-Lived User Access Token...");
OAuthRequest request = new OAuthRequest(Verb.GET
, "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token"
+ "&client_id=" + FB_APP_KEY + "&client_secret=" + FB_APP_SECRET
+ "&fb_exchange_token=" + fbAppShortLivedAccessToken.getToken());
oAuthService.signRequest(fbAppShortLivedAccessToken, request);
Response response = request.send();
if(response != null)
{
System.out.println("response.getBody() = " + response.getBody());
String responseBody = response.getBody();
if(responseBody != null && responseBody.contains("access_token="))
{
System.out.println("Old FB App Access Token = " + fbAppShortLivedAccessToken.getToken());
fbAppLongLivedAccessToken = new Token(responseBody.split("=")[1].trim(), "");
System.out.println("New FB App Access Token = " + fbAppLongLivedAccessToken.getToken());
}
}
return fbAppLongLivedAccessToken;
}
 
private static void postOnFacebookWallTimeline (OAuthService oAuthService, Token accessToken)
{
OAuthRequest request = new OAuthRequest(Verb.POST, "https://graph.facebook.com/me/feed");
SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
String message = "test message - " + sdf.format(new Date());
request.addBodyParameter("message", message);
String link = "http://codeoftheday.blogspot.com/";
request.addBodyParameter("link", link);
oAuthService.signRequest(accessToken, request);
 
Response response = request.send();
System.out.println(response.getCode());
String responseBody = response.getBody();
System.out.println(responseBody);
}
 
public static void main(String[] args)
{
OAuthService oAuthService = getOAuthService();
 
Token accessToken;
 
//facebook app's short-lived access token
//accessToken = getFbAppShortLivedAccessToken(oAuthService);
//accessToken = new Token("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef", "");
 
//facebook app's long-lived access token
//accessToken = getFbAppLongLivedAccessToken(oAuthService, accessToken);
accessToken = new Token("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef", "");
 
postOnFacebookWallTimeline(oAuthService, accessToken);
 
}*/
 
}