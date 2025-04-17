import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        int height = GetMonitorHeight(1080), width = GetMonitorWidth(1980);
        InitWindow(width, height, "Zantrum - crato con Raylib Java");
        SetTargetFPS(60);// Set our game to run at 60 frames-per-second

        Inventory Inventory = new Inventory();
        while (!WindowShouldClose()){

            BeginDrawing();
            ClearBackground(RAYWHITE);

            DrawText("Zantrum", 110, 490, 100, BLACK);

            //
            for (int i = 0; i < Inventory.cardsDb.size(); i++) {
                /*
                DrawText("Nome: " + Inventory.cardsDb.get(i).getName(), 110, 120, 20, BLACK);
                DrawText("Vita: " + Inventory.cardsDb.get(i).getLife(), 110, 150, 20, DARKGREEN);
                DrawText("Descrizione:", 110, 180, 20, BLACK);
                DrawText(Inventory.cardsDb.get(i).getDescription(), 110, 210, 18, GRAY);
                */
            }

            EndDrawing();
        }
        CloseWindow();
    }
}