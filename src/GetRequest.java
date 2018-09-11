import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {
	
	private String url;
	private String response;
	private final String USER_AGENT = "Mozilla/5.0";
	
	public GetRequest(String url) {
		this.url = url;
	}
	
	public String send() throws Exception{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer responseBuf = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responseBuf.append(inputLine);
		}
		in.close();

		response = responseBuf.toString();
		
		return response;
	}
}
