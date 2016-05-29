package util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yz
 * @date 5/18/16
 */
public class TestUtil {

  public static final String PATH_HELLO = "/hello";
  public static final String MSG_HELLO = "Hello World!";

  public static final Map<String, String> MSG_MAPPER = new HashMap<>();

  public static final String PATH_1 = "/1";

  public static final String PATH_2 = "/2";

  public static final String PATH_4 = "/4";

  public static final String PATH_8 = "/8";

  public static final String PATH_16 = "/16";

  public static final String PATH_32 = "/32";

  public static final String PATH_64 = "/64";

  public static final String PATH_128 = "/128";

  public static final String PATH_256 = "/256";

  public static final String PATH_512 = "/512";

  public static final String PATH_1024 = "/1024";

  static {
    MSG_MAPPER.put(PATH_HELLO, MSG_HELLO);
    MSG_MAPPER.put(PATH_1, read(TestUtil.class.getClassLoader().getResource("test/1").getPath()));
    MSG_MAPPER.put(PATH_2, read(TestUtil.class.getClassLoader().getResource("test/2").getPath()));
    MSG_MAPPER.put(PATH_4, read(TestUtil.class.getClassLoader().getResource("test/4").getPath()));
    MSG_MAPPER.put(PATH_8, read(TestUtil.class.getClassLoader().getResource("test/8").getPath()));
    MSG_MAPPER.put(PATH_16, read(TestUtil.class.getClassLoader().getResource("test/16").getPath()));
    MSG_MAPPER.put(PATH_32, read(TestUtil.class.getClassLoader().getResource("test/32").getPath()));
    MSG_MAPPER.put(PATH_64, read(TestUtil.class.getClassLoader().getResource("test/64").getPath()));
  }

  public static String read(String path) {
    StringBuilder sbBuilder = new StringBuilder();
    File file = new File(path);
    try {
      InputStream is = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      String line;
      while((line = br.readLine()) != null) {
        sbBuilder.append(line);
      }
      br.close();
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sbBuilder.toString();
  }
}
