package bg.kin4you.management.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageManager {
	
	
	public static void saveImage(MultipartFile file,String imgName) throws IOException {
		
		byte[] bytes = file.getBytes();
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		String format = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."), file.getOriginalFilename().length());
		
		Path path = Paths.get(absolutePath + "/src/main/resources/static/photos/" + imgName.concat(format));
		Files.write(path, bytes);
	}
}
