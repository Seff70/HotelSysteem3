package com.capgemini;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class WindowedWebApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.generate-ddl","true");
        SpringApplication springApplication = new SpringApplication(Main.class);
        springApplication.setDefaultProperties(properties);
        ConfigurableApplicationContext applicationContext = springApplication.run();
        WebView webView = new WebView();
        webView.getEngine().load( "http://localhost:8080" );
        Scene scene = new Scene( webView );
        primaryStage.setScene( scene );
        primaryStage.setFullScreen( true );
        primaryStage.setOnCloseRequest( event -> applicationContext.close() );
        primaryStage.addEventHandler( KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                primaryStage.close();
            }
        });
        primaryStage.show();
    }
}
