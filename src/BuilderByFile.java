import algorithms.enums.AlgorithmTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuilderByFile {

    private String path;

    public BuilderByFile(String path) {
        this.path = path;
    }

    public AlgorithmInterface buildAlg() {
        return readFile();
    }

    private AlgorithmInterface readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();

            AlgorithmInterface alg = AlgorithmTypes.getAlgorithmByDesc(linha);

            return alg;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquvio não localizado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int buildN() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();
            linha = br.readLine();
            int valor = Integer.parseInt(linha);
            return valor;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquvio não localizado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
