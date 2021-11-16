package src.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.model.vo.EquipamentoVO;
import src.model.vo.UsuarioVO;
import src.model.vo.VendaVO;
import src.view.telas.telasNome;

public class TelasPrincipal extends Application{

    private static Stage pricipal;
    private static UsuarioVO user;
    private static EquipamentoVO equipamento;
    private static VendaVO venda;

    public static Stage getPricipal() {
        return pricipal;
    }
    public static void setPricipal(Stage pricipal) {
        TelasPrincipal.pricipal = pricipal;
    }
    public static UsuarioVO getUser() {
        return user;
    }
    public static void setUser(UsuarioVO user) {
        TelasPrincipal.user = user;
    }
    public static EquipamentoVO getEquipamento() {
        return equipamento;
    }
    public static void setEquipamento(EquipamentoVO equipamento) {
        TelasPrincipal.equipamento = equipamento;
    }
    
    public static VendaVO getVenda() {
        return venda;
    }
    public static void setVenda(VendaVO venda) {
        TelasPrincipal.venda = venda;
    }


    public static void main(String args[]) {
        launch();
    }

    public static void load(telasNome telasNome) { 
        try {
            Parent root = FXMLLoader.load(TelasPrincipal.class.getResource("./telas/" + telasNome + ".fxml"));
            Scene scene = new Scene(root);
    
            pricipal.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start(Stage pricipal) throws Exception {
        setPricipal(pricipal);

        pricipal.setTitle("Casa Tech");
        load(telasNome.login); //Tela que irá aparecer quano programa iniciar
        pricipal.show();
    }

}
