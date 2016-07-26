import org.mybatis.generator.api.ShellRunner;

/**
 * Created by lixuejiao on 16/7/26.
 */
public class GeneratorMain {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "-configfile";
        GeneratorMain.class.getResource("/");
        String configRootPath = GeneratorMain.class.getResource("/").getPath();
        args[1] = configRootPath+"generator.xml";
        args[2] = "-overwrite";
        ShellRunner.main(args);
    }
}
