import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.management.ObjectName;

import com.ibm.websphere.management.AdminClient;
import com.ibm.websphere.management.AdminClientFactory;


public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
        props.setProperty(AdminClient.CONNECTOR_PORT, "8879");
        props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        AdminClient client = AdminClientFactory.createAdminClient(props);
        ObjectName mbean = (ObjectName)client.queryNames(new ObjectName("WebSphere:type=ConfigServiceMetaData,*"), null).iterator().next();
        byte[] jarContent = (byte[])client.invoke(mbean, "extractMetaData", new Object[0], new String[0]);
        JarInputStream jar = new JarInputStream(new ByteArrayInputStream(jarContent));
        JarEntry entry;
        byte[] buffer = new byte[4096];
        while ((entry = jar.getNextJarEntry()) != null) {
            FileOutputStream out = new FileOutputStream("models/" + entry.getName());
            int c;
            while ((c = jar.read(buffer)) != -1) {
                out.write(buffer, 0, c);
            }
            out.close();
        }
    }
}
