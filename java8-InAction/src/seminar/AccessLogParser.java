package seminar;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AccessLogParser {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path p = Paths.get(AccessLogParser.class.getResource("access_log.log").toURI());
		
		Map<String, List<String>> logs = Files.lines(p)
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
