import org.mybatis.generator.api.ShellRunner;

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
