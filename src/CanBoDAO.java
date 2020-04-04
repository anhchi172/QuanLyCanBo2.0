import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CanBoDAO {
    private static final String FILE_NAME = "CanBo.txt";
    public void write(List<CanBo> s){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File file = new File(FILE_NAME);
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
        }catch (IOException e){
            e.printStackTrace();
        } finally {
             closeStream(fos);
             closeStream(oos);
        }
    }

    public void closeStream(OutputStream os){
        if (os!=null){
            try{
                os.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public List<CanBo> read(){
        List<CanBo> canBoList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(new File(FILE_NAME));
            ois = new ObjectInputStream(fis);
            canBoList = (List<CanBo>) ois.readObject();

        } catch (FileNotFoundException e){
            System.out.print("List is empty");

        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return canBoList;
    }

    private void closeStream(InputStream is){
        if (is!= null){
            try{
                is.close();

            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

}
