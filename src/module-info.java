module RPNCalculator
{
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	
	opens calc to javafx.graphics,javafx.fxml;
	
}