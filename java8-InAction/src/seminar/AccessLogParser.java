package seminar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AccessLogParser {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(AccessLogParser.class.getResourceAsStream("access_log.log")));
		Map<String, List<String>> logs = br.lines()
			.collect(Collectors.groupingBy(AccessLogParser::getMethod));
		
		logs.keySet().stream()
			.forEach((s) -> System.out.println(s + " : " + logs.get(s).size()));
	}
	
	public static String getMethod(String src) {
		Pattern r = Pattern.compile(".*\"([A-Z]+).*", Pattern.DOTALL);
        Matcher m = r.matcher(src);
        return m.find() ? m.group(1) : "ERROR";
	}
}
