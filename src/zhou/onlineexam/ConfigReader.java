package zhou.onlineexam;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 负责读取配置文件中的配置信息
 * 单例模式设计该类
 *
 * @author stalley
 */
public class ConfigReader extends Properties
{

    private static ConfigReader instance = new ConfigReader();

    private ConfigReader()
    {
        //所有的文件操作都离不开IO操作
        //将文件加载到输入流（内存）
        //getResourceAsStream("config.properties"); 参数是文件的类路径，bin下面的路径
        //类路径是根据src来生成，所以类路径的结构跟 src 目录的结构一样
        InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("com/softeem/demo/util/config.properties");
        //读取输入流中的数据
        try {
            super.load(is);
        } catch (IOException e) {
            //打印堆栈异常信息
            e.printStackTrace();
            //抛出异常 RuntimeException：运行时异常：java要求程序必须对运行时异常进行处理
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static ConfigReader getInstance()
    {
        return instance;
    }


}
