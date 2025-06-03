package rna;

public class RnaTranscriber {

    public String transcribe(String dna) {
        if (dna == null) {
            throw new IllegalArgumentException("DNA string cannot be null");
        }

        StringBuilder rna = new StringBuilder();
        for (char nucleotide : dna.toCharArray()) {
            switch (nucleotide) {
                case 'G': rna.append('C'); break;
                case 'C': rna.append('G'); break;
                case 'T': rna.append('A'); break;
                case 'A': rna.append('U'); break;
                default:
                    throw new IllegalArgumentException("Invalid DNA nucleotide: " + nucleotide);
            }
        }
        return rna.toString();
    }
    
    public static void main(String[] args) {
        RnaTranscriber transcriber = new RnaTranscriber();
        String input = "GCTA";
        String output = transcriber.transcribe(input);
        System.out.println("DNA: " + input);
        System.out.println("RNA: " + output);
    }
}
