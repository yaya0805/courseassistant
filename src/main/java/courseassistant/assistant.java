package courseassistant;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class assistant {
	public static void main(String[] args) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		
		
		//ssl client
		SSLContextBuilder builder = new SSLContextBuilder();
	    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
	    @SuppressWarnings("deprecation")
		CloseableHttpClient client = HttpClients.custom().setHostnameVerifier(new AllowAllHostnameVerifier()).build();
	    
	    // request
		HttpGet req = new HttpGet("https://www.ccxp.nthu.edu.tw/ccxp/INQUIRE/");
		
		//response
		CloseableHttpResponse res =  client.execute(req);
		HttpEntity entity = res.getEntity();
		String str = EntityUtils.toString(entity);
		if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			//System.out.println(str);
			
		}
		else{
			System.out.println(res.getStatusLine().getStatusCode());
		}
	    
	}
}
