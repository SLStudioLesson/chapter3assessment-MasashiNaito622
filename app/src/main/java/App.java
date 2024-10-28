
import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

//import javax.xml.crypto.Data;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;
            
            if("1".equals(choice)){
                //「1」を選択した場合、CSVDataHandlerインスタンスを生成
                dataHandler = new CSVDataHandler();
            }else if("2".equals(choice)){
                //「2」を選択した場合、JSONDataHandlerインスタンスを生成
                dataHandler = new JSONDataHandler();
            }else{
                //（「1」「2」以外）が与えられた場合、CSVDataHandlerインスタンスを生成
                dataHandler = new CSVDataHandler();
            }
            //System.out.println("Current mode: "+dataHandler.getMode());

            //選択されたデータハンドラーをcom/recipeappパッケージのRecipeUIに渡す
            RecipeUI ui = new RecipeUI(dataHandler);
            //displayMenuメソッドを呼び出してメインメニューを表示
            ui.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}