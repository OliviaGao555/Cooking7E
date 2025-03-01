package com.example.cooking7e;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Stage successStage = new Stage();
    public Label floatingLabelShelf = new Label("");
    public Label floatingLabelFridge = new Label("");
    public Label floatingLabelCondiment = new Label("");
    private Pane labelLayer1;
    private Pane labelLayer2;
    private Pane labelLayer3;
    private List<String> selected;
    private int time = 0;
    private int dish = 0;
    List<String> kpc;
    List<String> cbpfh;
    List<String> biibs;
    List<String> cslh;
    List<String> dp;
    List<String> pwsv;
    List<String> bt;

    // Sauce
    private final ImageView whiteVinegar = new ImageView("file:BAIVI.png");
    private final ImageView darkSoySauce = new ImageView("file:LAO.png");
    private final ImageView cookingWine = new ImageView("file:LIAO.png");
    private final ImageView riceVinegar = new ImageView("file:RIVI.png");
    private final ImageView lightSoySauce = new ImageView("file:SHENG.png");
    private final ImageView vinegar = new ImageView("file:VI.png");
    private final ImageView seafoodSoySauce = new ImageView("file:ZHENGYU.png");
    private final ImageView oysterSauce = new ImageView("file:HAO.png");
    private final ImageView shaoXingWine = new ImageView("file:HUA.png");
    private final ImageView yellowWine = new ImageView("file:HUANG.png");
    private final ImageView soySauce = new ImageView("file:JIANG.png");
    // Meat
    private final ImageView chicken = new ImageView("file:CHICKEN.png");
    private final ImageView mincedPork = new ImageView("file:MINCED.png");
    private final ImageView pork = new ImageView("file:PORC.png");
    private final ImageView pigIntestines = new ImageView("file:PIG.png");
    private final ImageView fishHead = new ImageView("file:FISH.png");
    // Condiment
    private final ImageView salt = new ImageView("file:salt.png");
    private final ImageView starAnise = new ImageView("file:BAJIAO.png");
    private final ImageView cornStarch = new ImageView("file:CORN.png");
    private final ImageView peppercorns = new ImageView("file:PPER.png");
    private final ImageView sugar = new ImageView("file:SUGAR.png");
    private final ImageView driedPepper = new ImageView("file:DRY.png");
    private final ImageView matsutakeMushroomSeasoning = new ImageView("file:SR.png");
    private final ImageView oil = new ImageView("file:oil.png");
    private final ImageView groundWhitePepper = new ImageView("file:wpp.png");
    private final ImageView peanuts = new ImageView("file:pnt.png");
    // Veggie
    private final ImageView springOnion = new ImageView("file:ONION.png");
    private final ImageView garlic = new ImageView("file:GARLIC.png");
    private final ImageView ginger = new ImageView("file:GINGER.png");
    private final ImageView water = new ImageView("file:water.png");

    // Map
    ImageView a1 = new ImageView("file:1.png");
    ImageView a2 = new ImageView("file:2.png");
    ImageView a3 = new ImageView("file:3.png");
    ImageView a4 = new ImageView("file:4.png");
    ImageView a5 = new ImageView("file:5.png");
    ImageView a6 = new ImageView("file:6.png");
    ImageView a7 = new ImageView("file:7.png");
    ImageView a8 = new ImageView("file:8.png");
    ImageView recipeBook = new ImageView();

    // Ingredient labels
    VBox ingredients1;
    VBox ingredients2;
    Label ingredient1 = new Label(""); Label ingredient6 = new Label(""); Label ingredient11 = new Label(""); Label ingredient16 = new Label(""); Label ingredient21 = new Label("");
    Label ingredient2 = new Label(""); Label ingredient7 = new Label(""); Label ingredient12 = new Label(""); Label ingredient17 = new Label(""); Label ingredient22 = new Label("");
    Label ingredient3 = new Label(""); Label ingredient8 = new Label(""); Label ingredient13= new Label(""); Label ingredient18 = new Label(""); Label ingredient23 = new Label("");
    Label ingredient4 = new Label(""); Label ingredient9 = new Label(""); Label ingredient14 = new Label(""); Label ingredient19 = new Label(""); Label ingredient24 = new Label("");
    Label ingredient5 = new Label(""); Label ingredient10 = new Label(""); Label ingredient15 = new Label(""); Label ingredient20 = new Label("");

    // Sound
    private File soundFile = new File("camera.wav");
    private Media media = new Media(soundFile.toURI().toString());
    MediaPlayer player = new MediaPlayer(media);
    private File cookingSound = new File("ding.mp3");
    private Media media2 = new Media(cookingSound.toURI().toString());
    MediaPlayer cookingSoundPlay = new MediaPlayer(media2);

    @Override
    public void start(Stage stage) throws IOException {
        // Set up floating labels.
        labelLayer1 = new Pane(); // For shelf.
        labelLayer1.setMouseTransparent(true);
            floatingLabelShelf = new Label("");
            floatingLabelShelf.setStyle("-fx-background-color: white; -fx-padding: 1");
            floatingLabelShelf.setVisible(false);
        labelLayer1.getChildren().add(floatingLabelShelf);
        labelLayer2 = new Pane(); // Foe fridge.
        labelLayer2.setMouseTransparent(true);
        floatingLabelFridge = new Label("");
        floatingLabelFridge.setStyle("-fx-background-color: white; -fx-padding: 1");
        floatingLabelFridge.setVisible(false);
        labelLayer2.getChildren().add(floatingLabelFridge);
        labelLayer3 = new Pane(); // For condiment.
        labelLayer3.setMouseTransparent(true);
        floatingLabelCondiment = new Label("");
        floatingLabelCondiment.setStyle("-fx-background-color: white; -fx-padding: 1");
        floatingLabelCondiment.setVisible(false);
        labelLayer3.getChildren().add(floatingLabelCondiment);

        // Set up map.
        a1.setVisible(false); a2.setVisible(false); a3.setVisible(false); a4.setVisible(false); a5.setVisible(false); a6.setVisible(false); a7.setVisible(false); a8.setVisible(false);

        // Set up recipes.
        // Kung Pao Chicken; Chop Bell Pepper Fish Head; Braised Intestines in Brown Sauce;
        // Crab Sauce Lion's Head; Dongpo Pork; Pork with Salted Vegetable; Buddha's Temptation.
        kpc = new ArrayList<>(List.of("Chicken Thigh", "Salt", "Corn Starch", "Water", "Oil", "Garlic", "Ginger", "Spring Onion", "Dried Pepper", "Sugar", "Vinegar", "Light Soy Sauce", "Dark Soy Sauce", "Ground White Pepper", "Peanuts", "Peppercorns"));
        cbpfh = new ArrayList<>(List.of("Fish Head", "Salt", "Cooking Wine", "Chopped Chili", "Fresh Pepper", "Ginger", "Garlic", "Oil", "Fermented Black Soybean", "Seafood Soy Sauce", "Sugar", "Pepper", "Spring Onion"));
        biibs = new ArrayList<>(List.of("Pig Intestines", "Spring Onion", "Ginger", "Star Anise", "Dried Pepper", "Peppercorns", "Ground White Pepper", "Yellow Wine", "Oil", "Sugar", "Water", "Light Soy Sauce", "Soy Sauce", "Rice Vinegar", "White Vinegar", "Cinnamon Powder", "Sharen Powder"));
        cslh = new ArrayList<>(List.of("Minced Pork", "Salt", "Sugar", "Chicken Essence", "Pepper", "Cooking Wine", "Egg", "Ginger", "Spring Onion", "Water", "Starch", "mati", "Crab Powder", "Crab Roe", "Cabbages"));
        dp = new ArrayList<>(List.of("Pork", "Water", "Ginger", "Spring Onion", "Yellow Wine", "Soy Sauce", "Yellow Rock Sugar", "Salt"));
        pwsv = new ArrayList<>(List.of("Dried Pickled Vegetables", "Sugar", "Oil", "Pork", "Spring Onion", "Ginger", "Garlic", "Red Bean Curd", "Peanut Butter", "Chu Hou Sauce", "Sweat Bean Sauce", "Five-Spice Powder", "Soy Sauce", "Oyster Sauce", "Cooking Wine", "Matsutake Mushroom Seasoning", "Yellow Wine"));
        bt = new ArrayList<>(List.of());


        // Set up selected ingredients list.
        selected = new ArrayList<>();

        // Set up visual selected list.
        HBox ingredients = new HBox(40);
            ingredients1 = new VBox(8);
            ingredients1.setAlignment(Pos.CENTER);
            ingredients2 = new VBox(8);
            ingredients2.setAlignment(Pos.CENTER);
                    String labelStyle = "-fx-font-size: 12;";
                    ingredient1.setStyle(labelStyle); ingredient2.setStyle(labelStyle); ingredient3.setStyle(labelStyle); ingredient4.setStyle(labelStyle); ingredient5.setStyle(labelStyle); ingredient6.setStyle(labelStyle); ingredient7.setStyle(labelStyle); ingredient8.setStyle(labelStyle); ingredient9.setStyle(labelStyle); ingredient10.setStyle(labelStyle); ingredient11.setStyle(labelStyle); ingredient12.setStyle(labelStyle); ingredient13.setStyle(labelStyle); ingredient14.setStyle(labelStyle); ingredient15.setStyle(labelStyle); ingredient16.setStyle(labelStyle); ingredient17.setStyle(labelStyle); ingredient18.setStyle(labelStyle); ingredient19.setStyle(labelStyle); ingredient20.setStyle(labelStyle); ingredient21.setStyle(labelStyle); ingredient22.setStyle(labelStyle); ingredient23.setStyle(labelStyle); ingredient24.setStyle(labelStyle);
            ingredients1.getChildren().addAll(ingredient1, ingredient3, ingredient5, ingredient7, ingredient9, ingredient11, ingredient13, ingredient15, ingredient17, ingredient19, ingredient21, ingredient23);
            ingredients2.getChildren().addAll(ingredient2, ingredient4, ingredient6, ingredient8, ingredient10, ingredient12, ingredient14, ingredient16, ingredient18, ingredient20, ingredient22, ingredient24);
        ingredients.getChildren().addAll(ingredients1, ingredients2);
        ingredients.setAlignment(Pos.CENTER);
        ingredients.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        ingredients.setTranslateY(80);
        ingredients.setTranslateX(3);
        ingredients.setRotate(1);

        // Set up image view actions.
        if (dish == 0) {
            recipeBook.setImage(new Image("file:kpcR.png"));
            pressIngredient(chicken, "Chicken Thigh", ingredient1);
            pressIngredient(salt, "Salt", ingredient2);
            pressIngredient(cornStarch, "Corn Starch", ingredient3);
            pressIngredient(garlic, "Garlic", ingredient4);
            pressIngredient(ginger, "Ginger", ingredient5);
            pressIngredient(springOnion, "Spring Onion", ingredient6);
            pressIngredient(driedPepper, "Dried Pepper", ingredient7);
            pressIngredient(sugar, "Sugar", ingredient8);
            pressIngredient(vinegar, "Vinegar", ingredient9);
            pressIngredient(lightSoySauce, "Light Soy Sauce", ingredient10);
            pressIngredient(darkSoySauce, "Dark Soy Sauce", ingredient11);
            pressIngredient(peppercorns, "Peppercorns", ingredient12);
            pressIngredient(water, "Water", ingredient13);
            pressIngredient(oil, "Oil", ingredient14);
            pressIngredient(peanuts, "Peanuts", ingredient15);
            pressIngredient(groundWhitePepper, "Ground White Pepper", ingredient16);
        }
        if (dish == 1) {
            recipeBook.setImage(new Image("file:learn.png"));
            pressIngredient(cookingWine, "Cooking Wine", ingredient1);
            pressIngredient(riceVinegar, "Rice Vinegar", ingredient2);
            pressIngredient(whiteVinegar, "White Vinegar", ingredient3);
            pressIngredient(seafoodSoySauce, "Seafood Soy Sauce", ingredient4);
            pressIngredient(oysterSauce, "Oyster Sauce", ingredient5);
            pressIngredient(shaoXingWine, "Shao Xing Wine", ingredient6);
            pressIngredient(yellowWine, "Yellow Wine", ingredient7);
            pressIngredient(soySauce, "Soy Sauce", ingredient8);
            pressIngredient(mincedPork, "Minced Pork", ingredient9);
            pressIngredient(pork, "Pork", ingredient10);
            pressIngredient(pigIntestines, "Pig Intestines", ingredient11);
            pressIngredient(fishHead, "Fish Head", ingredient12);
            pressIngredient(starAnise, "Star Anise", ingredient13);
            pressIngredient(matsutakeMushroomSeasoning, "Matsutake Mushroom Seasoning", ingredient14);
        }

        // Set up image views that allow popups.
        ImageView shelf = new ImageView("file:shelf.png");
        shelf.setOnMousePressed(event -> openShelf());
        ImageView condiment = new ImageView("file:condiment.png");
        condiment.setOnMousePressed(event -> openCondiment());
        ImageView fridge = new ImageView("file:fridge.png");
        fridge.setOnMousePressed(event -> openFridge());
        ImageView question = new ImageView("file:q.png");
        question.setOnMousePressed(event -> openQuestion());

        // Set up backgrounds.
        Image bg1 = new Image("file:bg1.png");
        ImageView bg1V = new ImageView(bg1);
        Image bg2 = new Image("file:bg2.png");
        ImageView bg2V = new ImageView(bg2);
        Image penguin = new Image("file:PEMGUIN.png");
        ImageView penguinV = new ImageView(penguin);

        // Set up tips.
        ImageView penguinTalk = new ImageView();
        Image p1 = new Image("file:p1.png");
        Image p2 = new Image("file:p2.png");
        Image p3 = new Image("file:p3.png");
        penguinTalk.setImage(p1);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(15), e -> {
                    if (time == 0) {
                        penguinTalk.setImage(p2);
                    } else if (time == 1) {
                        penguinTalk.setImage(p3);
                    } else {
                        penguinTalk.setImage(p1);
                    }
                    time = (time + 1) % 3;
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        recipeBook.setScaleY(1.28);
        recipeBook.setScaleX(1.28);

        // Set up cook button.
        ImageView cook = new ImageView("file:cook.png");
        cook.setOnMouseClicked(e -> {
            if (dish == 0) {
                selected.removeIf(item -> !kpc.contains(item));
                checkRecipeSuccess(stage, selected, kpc);
            }
        });

        // Put together everything.
        StackPane pane = new StackPane(bg1V, bg2V, ingredients, fridge, condiment, shelf, penguinV, penguinTalk, question, cook, recipeBook);
        Scene scene = new Scene(pane, 810, 500);
        stage.setTitle("Cooking 7E");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void checkRecipeSuccess(Stage stage, List<String> selected, List<String> recipe) {
        // Check if all required ingredients are selected
        if (selected.size() == recipe.size() && selected.containsAll(recipe) && recipe.containsAll(selected)) {
            // Set up success popup
            ImageView cooked = new ImageView(new Image("file:kpc.png"));
            successStage = new Stage();
            cooked.setScaleY(0.5);
            cooked.setScaleX(0.5);
            VBox popupVBox = new VBox(20);
            popupVBox.setAlignment(Pos.CENTER);
            popupVBox.getChildren().addAll(cooked);

            Scene popupScene = new Scene(popupVBox, 400, 250);
            successStage.setScene(popupScene);
            successStage.setTitle("Kung Pao Chicken - Sichuan");
            successStage.show();
            cookingSoundPlay.stop();
            cookingSoundPlay.seek(Duration.ZERO);
            cookingSoundPlay.play();
            dish++;
            selected.clear();
            resetIngredientLabels();
            populateIngredients();
        }
    }

    public void openShelf() {
        // Set up shelf's popup
        player.stop();
        player.seek(Duration.ZERO);
        player.play();
        Stage popupStage = new Stage();
        popupStage.setTitle("Get Sauce!");
        popupStage.setResizable(false);

        // Add in ingredients.
        HBox materialsBox1 = new HBox(10);
        materialsBox1.setAlignment(Pos.TOP_CENTER);
        materialsBox1.setPadding(new Insets(10));
        materialsBox1.getChildren().addAll(vinegar, riceVinegar, whiteVinegar, soySauce, lightSoySauce, darkSoySauce);
        HBox materialsBox2 = new HBox(10);
        materialsBox2.setAlignment(Pos.TOP_CENTER);
        materialsBox2.setPadding(new Insets(10));
        materialsBox2.getChildren().addAll(seafoodSoySauce, oysterSauce, cookingWine, yellowWine, shaoXingWine);
        // Set up label for ingredients.
        shaoXingWine.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Shao Xing Wine");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(shaoXingWine);
        yellowWine.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Yellow Wine");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(yellowWine);
        soySauce.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Soy Sauce");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(soySauce);
        oysterSauce.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Oyster Sauce");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(oysterSauce);
        seafoodSoySauce.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Seafood Soy Sauce");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(seafoodSoySauce);
        whiteVinegar.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("White Vinegar");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(whiteVinegar);
        cookingWine.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Cooking Wine");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(cookingWine);
        riceVinegar.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Rice Vinegar");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(riceVinegar);
        vinegar.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Vinegar");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(vinegar);
        lightSoySauce.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Light Soy Sauce");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(lightSoySauce);
        darkSoySauce.setOnMouseEntered(event -> {
            floatingLabelShelf.setText("Dark Soy Sauce");
            floatingLabelShelf.setVisible(true);
        });
        exitSauce(darkSoySauce);

        // Set up layout for shelf window.
        ImageView shelfBackground = new ImageView(new Image("file:bg1.png"));
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.3);
        shelfBackground.setEffect(colorAdjust);
        StackPane layout = new StackPane();
        VBox materialsBox = new VBox(materialsBox1, materialsBox2);
        layout.getChildren().addAll(shelfBackground, materialsBox, labelLayer1);

        Scene popupScene = new Scene(layout, 400, 250);
        popupScene.setOnMouseMoved(event -> {
            floatingLabelShelf.setLayoutX(event.getX() + 10);
            floatingLabelShelf.setLayoutY(event.getY() + 10);
        });
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    public void openFridge() {
        // Set up fridge popup.
        player.stop();
        player.seek(Duration.ZERO);
        player.play();
        Stage popupStage = new Stage();
        popupStage.setTitle("Get Ingredients!");
        popupStage.setResizable(false);

        // Set up materials in the fridge.
        HBox materialsBox1 = new HBox(10);
        materialsBox1.setAlignment(Pos.TOP_CENTER);
        materialsBox1.setPadding(new Insets(10));
        materialsBox1.getChildren().addAll(garlic, ginger, springOnion, water);
        HBox materialsBox2 = new HBox(10);
        materialsBox2.setAlignment(Pos.TOP_CENTER);
        materialsBox2.setPadding(new Insets(10));
        materialsBox2.getChildren().addAll(chicken, fishHead);
        HBox materialsBox3 = new HBox(10);
        materialsBox3.setAlignment(Pos.TOP_CENTER);
        materialsBox3.setPadding(new Insets(10));
        materialsBox3.getChildren().addAll(mincedPork, pork, pigIntestines);
        // Add in labels.
        water.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Water");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(water);
        mincedPork.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Minced Pork");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(mincedPork);
        pork.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Pork");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(pork);
        pigIntestines.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Pig Intestines");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(pigIntestines);
        fishHead.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Fish Head");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(fishHead);
        chicken.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Chicken Thigh");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(chicken);
        garlic.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Garlic");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(garlic);
        ginger.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Ginger");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(ginger);
        springOnion.setOnMouseEntered(event -> {
            floatingLabelFridge.setText("Spring Onion");
            floatingLabelFridge.setVisible(true);
        });
        exitIngredient(springOnion);

        // Set up layout for fridge window.
        ImageView fridgeBackground = new ImageView(new Image("file:fridgeBG.png"));
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.3);
        fridgeBackground.setEffect(colorAdjust);
        StackPane layout = new StackPane();
        VBox materialsBox = new VBox(materialsBox1, materialsBox2, materialsBox3);
        layout.getChildren().addAll(fridgeBackground, materialsBox, labelLayer2);

        Scene popupScene = new Scene(layout, 400, 250);
        popupScene.setOnMouseMoved(event -> {
            floatingLabelFridge.setLayoutX(event.getX() + 10);
            floatingLabelFridge.setLayoutY(event.getY() + 10);
        });
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    public void openCondiment() {
        // Set up condiment popup.
        player.stop();
        player.seek(Duration.ZERO);
        player.play();
        Stage popupStage = new Stage();
        popupStage.setTitle("Get Condiment!");
        popupStage.setResizable(false);

        // Set up condiments.
        HBox materialsBox1 = new HBox(10);
        materialsBox1.setAlignment(Pos.TOP_CENTER);
        materialsBox1.setPadding(new Insets(10));
        materialsBox1.getChildren().addAll(oil, groundWhitePepper, salt, cornStarch, sugar);
        HBox materialsBox2 = new HBox(10);
        materialsBox2.setAlignment(Pos.TOP_CENTER);
        materialsBox2.setPadding(new Insets(10));
        materialsBox2.getChildren().addAll(matsutakeMushroomSeasoning, peppercorns, starAnise, driedPepper, peanuts);
        // Add labels.
        peanuts.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Peanuts");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(peanuts);
        oil.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Oil");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(oil);
        groundWhitePepper.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Ground White Pepper");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(groundWhitePepper);
        starAnise.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Star Anise");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(starAnise);
        matsutakeMushroomSeasoning.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Matsutake Mushroom Seasoning");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(matsutakeMushroomSeasoning);
        salt.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Salt");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(salt);
        cornStarch.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Corn Starch");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(cornStarch);
        driedPepper.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Dried Pepper");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(driedPepper);
        sugar.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Sugar");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(sugar);
        peppercorns.setOnMouseEntered(event -> {
            floatingLabelCondiment.setText("Peppercorns");
            floatingLabelCondiment.setVisible(true);
        });
        exitCondiment(peppercorns);

        // Set up layout for condiment window.
        ImageView condimentBackground = new ImageView(new Image("file:condimentBG.png"));
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.3);
        condimentBackground.setEffect(colorAdjust);
        StackPane layout = new StackPane();
        VBox materialsBox = new VBox(materialsBox1, materialsBox2);
        layout.getChildren().addAll(condimentBackground, materialsBox, labelLayer3);

        Scene popupScene = new Scene(layout, 400, 250);
        popupScene.setOnMouseMoved(event -> {
            floatingLabelCondiment.setLayoutX(event.getX() + 10);
            floatingLabelCondiment.setLayoutY(event.getY() + 10);
        });
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    public void openQuestion() {
        // Set up colored map.
        List<ImageView> imageViews = List.of(a1, a2, a3, a4, a5, a6, a7, a8);
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setVisible(dish > i);
        }
        ImageView qBackground = new ImageView(new Image("file:bg1.png"));
        ImageView map = new ImageView("file:map.png");
        ImageView instruction = new ImageView("file:qbg.png");
        instruction.setScaleX(0.5);
        instruction.setScaleY(0.5);
        map.setScaleX(0.5);
        map.setScaleY(0.5);

        // Set up question stage.
        Stage popupStage = new Stage();
        Stage popup2 = new Stage();
        popupStage.setResizable(false);
        popup2.setResizable(false);
        popupStage.setTitle("What are we cooking?");
        popup2.setTitle("How to cook?");

        // Set up layout for question window.
        StackPane layout = new StackPane();
        a1.setScaleX(0.5); a1.setScaleY(0.5);
        a2.setScaleX(0.5); a2.setScaleY(0.5);
        a3.setScaleX(0.5); a3.setScaleY(0.5);
        a4.setScaleX(0.5); a4.setScaleY(0.5);
        a5.setScaleX(0.5); a5.setScaleY(0.5);
        a6.setScaleX(0.5); a6.setScaleY(0.5);
        a7.setScaleX(0.5); a7.setScaleY(0.5);
        a8.setScaleX(0.5); a8.setScaleY(0.5);
        layout.getChildren().addAll(qBackground, map, a1, a2, a3, a4, a5, a6, a7, a8);
        HBox hBox = new HBox(instruction);
        hBox.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(layout, 400, 250);
        Scene popup2S = new Scene(hBox, 380, 230);
        popupStage.setScene(popupScene);
        popup2.setScene(popup2S);
        popup2.setAlwaysOnTop(true);
        popup2.show();
        popupStage.show();
    }

    private void pressIngredient(ImageView ingredient, String string, Label number) {
        // Set up action for when an image view is pressed.
        ingredient.setOnMousePressed(event -> {
            if (selected.contains(string)) {
                selected.remove(string);
                number.setText("");
            } else {
                selected.add(string);
                number.setText(string);
            }
        });
    }

    private void exitCondiment(ImageView ingredient) {
        // Make sure label disappears after leaving an ingredient.
        ingredient.setOnMouseExited(event -> {
            floatingLabelCondiment.setText("");
            floatingLabelCondiment.setVisible(false);
        });
    }
    private void exitIngredient(ImageView ingredient) {
        // Make sure label disappears after leaving an ingredient.
        ingredient.setOnMouseExited(event -> {
            floatingLabelFridge.setText("");
            floatingLabelFridge.setVisible(false);
        });
    }
    private void exitSauce(ImageView ingredient) {
        // Make sure label disappears after leaving an ingredient.
        ingredient.setOnMouseExited(event -> {
            floatingLabelShelf.setText("");
            floatingLabelShelf.setVisible(false);
        });
    }

    private void resetIngredientLabels() {
        // Make sure selected ingredients disappear after successfully cooking.
        for (Label label : List.of(ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6,
                ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12,
                ingredient13, ingredient14, ingredient15, ingredient16, ingredient17, ingredient18,
                ingredient19, ingredient20, ingredient21, ingredient22, ingredient23, ingredient24)) {
            label.setText("");
        }
    }

    private void populateIngredients() {
        // Make sure selected ingredients are all unselected, and reset event handler.
        clearEventHandlers();
        if (dish == 0) {
            recipeBook.setImage(new Image("file:kpcR.png"));
            pressIngredient(chicken, "Chicken Thigh", ingredient1);
            pressIngredient(salt, "Salt", ingredient2);
            pressIngredient(cornStarch, "Corn Starch", ingredient3);
            pressIngredient(garlic, "Garlic", ingredient4);
            pressIngredient(ginger, "Ginger", ingredient5);
            pressIngredient(springOnion, "Spring Onion", ingredient6);
            pressIngredient(driedPepper, "Dried Pepper", ingredient7);
            pressIngredient(sugar, "Sugar", ingredient8);
            pressIngredient(vinegar, "Vinegar", ingredient9);
            pressIngredient(lightSoySauce, "Light Soy Sauce", ingredient10);
            pressIngredient(darkSoySauce, "Dark Soy Sauce", ingredient11);
            pressIngredient(peppercorns, "Peppercorns", ingredient12);
            pressIngredient(water, "Water", ingredient13);
            pressIngredient(oil, "Oil", ingredient14);
            pressIngredient(peanuts, "Peanuts", ingredient15);
            pressIngredient(groundWhitePepper, "Ground White Pepper", ingredient16);
        }if (dish == 1) {
            recipeBook.setImage(new Image("file:learn.png"));
            pressIngredient(cookingWine, "Cooking Wine", ingredient1);
            pressIngredient(riceVinegar, "Rice Vinegar", ingredient2);
            pressIngredient(whiteVinegar, "White Vinegar", ingredient3);
            pressIngredient(seafoodSoySauce, "Seafood Soy Sauce", ingredient4);
            pressIngredient(oysterSauce, "Oyster Sauce", ingredient5);
            pressIngredient(shaoXingWine, "Shao Xing Wine", ingredient6);
            pressIngredient(yellowWine, "Yellow Wine", ingredient7);
            pressIngredient(soySauce, "Soy Sauce", ingredient8);
            pressIngredient(mincedPork, "Minced Pork", ingredient9);
            pressIngredient(pork, "Pork", ingredient10);
            pressIngredient(pigIntestines, "Pig Intestines", ingredient11);
            pressIngredient(fishHead, "Fish Head", ingredient12);
            pressIngredient(starAnise, "Star Anise", ingredient13);
            pressIngredient(matsutakeMushroomSeasoning, "Matsutake Mushroom Seasoning", ingredient14);
        }
    }

    private void clearEventHandlers() {
        // Clear event handlers for all ingredients.
        chicken.setOnMousePressed(null);
        salt.setOnMousePressed(null);
        cornStarch.setOnMousePressed(null);
        garlic.setOnMousePressed(null);
        ginger.setOnMousePressed(null);
        springOnion.setOnMousePressed(null);
        driedPepper.setOnMousePressed(null);
        sugar.setOnMousePressed(null);
        vinegar.setOnMousePressed(null);
        lightSoySauce.setOnMousePressed(null);
        darkSoySauce.setOnMousePressed(null);
        peppercorns.setOnMousePressed(null);
        cookingWine.setOnMousePressed(null);
        riceVinegar.setOnMousePressed(null);
        whiteVinegar.setOnMousePressed(null);
        seafoodSoySauce.setOnMousePressed(null);
        oysterSauce.setOnMousePressed(null);
        shaoXingWine.setOnMousePressed(null);
        yellowWine.setOnMousePressed(null);
        soySauce.setOnMousePressed(null);
        mincedPork.setOnMousePressed(null);
        pork.setOnMousePressed(null);
        pigIntestines.setOnMousePressed(null);
        fishHead.setOnMousePressed(null);
        starAnise.setOnMousePressed(null);
        matsutakeMushroomSeasoning.setOnMousePressed(null);
        oil.setOnMousePressed(null);
        water.setOnMousePressed(null);
        groundWhitePepper.setOnMousePressed(null);
        peanuts.setOnMousePressed(null);
    }

    public static void main(String[] args) {
        launch();
    }
}
