import java.util.ArrayList;

public class LopCanBo {
    private ArrayList<CanBo> canBoArrayList;
    private CanBoDAO canBoDAO;

    public LopCanBo(){
        canBoDAO = new CanBoDAO();
        canBoArrayList = (ArrayList<CanBo>) canBoDAO.read();

    }

    public void add(CanBo b){
        canBoArrayList.add(b);
        canBoDAO.write(canBoArrayList);
    }

    public CanBo timTheoTen(String ten){
        CanBo b = canBoArrayList.stream()
                .filter(x -> ten.equalsIgnoreCase(x.getTen()))
                .findAny()
                .orElse(null);
        return b;

    }

    public void show(){
        for (CanBo b : canBoArrayList){
            System.out.print(b.toString());

        }
    }
}
