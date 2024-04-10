package MyClass;
import java.util.Arrays;
import java.util.Random;

public class PricePredictor {
    private double[] theta;
    private double alpha;
    private int iterations;
    private double[][] data;
    
    public PricePredictor(double[][] data) {
        if (data.length > 0 && data[0].length > 0) { // Vérifiez que le tableau n'est pas vide
            this.theta = new Random().doubles(data[0].length).toArray();
        } else {
            // Traitez le cas où le tableau est vide
            throw new IllegalArgumentException("Data array must not be empty");
        }
        this.alpha = 0.01;
        this.iterations = 1000;
        this.data = data;
    }

    public double computeCost(double[][] X, double[] y) {
        int m = y.length;
        double cost = 0;
        for (int i = 0; i < m; i++) {
            double prediction = 0;
            for (int j = 0; j < theta.length; j++) {
                prediction += X[i][j] * theta[j];
            }
            cost += Math.pow(prediction - y[i], 2);
        }
        return cost / (2 * m);
    }

    public void gradientDescent(double[][] X, double[] y) {
        int m = y.length;
        for (int i = 0; i < iterations; i++) {
            double[] prediction = new double[m];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < theta.length; k++) {
                    prediction[j] += X[j][k] * theta[k];
                }
            }
            for (int j = 0; j < theta.length; j++) {
                double errorSum = 0;
                for (int k = 0; k < m; k++) {
                    errorSum += (prediction[k] - y[k]) * X[k][j];
                }
                theta[j] -= alpha * (1.0 / m) * errorSum;
            }
        }
    }

    public double predictPrice(double[] newProduct) {
        double[] modelInput = Arrays.copyOf(newProduct, newProduct.length + 1);
        modelInput[0] = 1; // Ajout du terme de biais
        double predictedPrice = 0;
        for (int i = 0; i < theta.length; i++) {
            predictedPrice += modelInput[i] * theta[i];
        }
        return predictedPrice;
    }
}