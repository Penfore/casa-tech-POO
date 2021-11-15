package src.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.view.telas.telasSecundarias.telasSecNome;

public class TelasSecudaria {
    private static Stage Secundaria;

    public static Stage getSecundaria() {
        return Secundaria;
    }

    public static void setSecundaria(Stage secundaria) {
        Secundaria = secundaria;
    }

    public static void load(telasSecNome telasSecNome) {
        try {
            if(Secundaria == null) {
                Stage novaTelaSec = new Stage();
                setSecundaria(novaTelaSec);
            }

            Parent root = FXMLLoader.load(TelasPrincipal.class.getResource("./telas/telasSecundarias/" + telasSecNome + ".fxml"));
            Scene scene = new Scene(root);

            Secundaria.setTitle(telasSecNome.toString());
            Secundaria.setScene(scene);
            Secundaria.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fechar() {
        Secundaria.hide();
    }
}
