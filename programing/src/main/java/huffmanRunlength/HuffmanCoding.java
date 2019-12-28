package huffmanRunlength;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class HuffmanCoding {

    private List<Run> runList = new ArrayList<>();
    private Heap<Run> heap;
    private Run theRoot = null;
    private Run[] chars = new Run[256];

    private void createHuffmanTree() {

        heap = new Heap<>();
        for (Run run : runList) {
            heap.insert(run);
        }
        while (heap.size() > 1) {

            Run firstRun = heap.delete();
            Run secondRun = heap.delete();
            int frequency = firstRun.getFrequency() + secondRun.getFrequency();

            Run newRun = new Run(null, null, frequency);

            newRun.left = firstRun;
            newRun.right = secondRun;

            heap.insert(newRun);
        }
        theRoot = heap.get(0);

    }

    private void printHuffmanTree() {
        preOrderTraverse(theRoot, 0);
    }

    private void preOrderTraverse(Run node, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("  ");

        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.toString());
            preOrderTraverse(node.left, depth + 1);
            preOrderTraverse(node.right, depth + 1);
        }

    }

    private void collectRuns(RandomAccessFile file) throws IOException {

        byte getByte = file.readByte(), readByte = 0;
        int count = 1;
        for (int i = 1; i < file.length(); i++) {
            readByte = file.readByte();
            count++;
            if (readByte != getByte) {
                Run run = new Run(getByte, count - 1, 1);
                if (!runExist(runList, run)) {
                    runList.add(run);
                }
                getByte = readByte;
                count = 1;
            }

            if (i == file.length() - 1) {
                Run run = new Run(readByte, count, 1);
                if (!runExist(runList, run)) {
                    runList.add(run);
                }
            }
        }
    }

    private boolean runExist(List<Run> runList, Run getRun) {
        for (Run run : runList) {
            if (getRun.equals(run)) {
                run.setFrequency(run.getFrequency() + 1);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        HuffmanCoding app = new HuffmanCoding();
        RandomAccessFile file;
        file = new RandomAccessFile("C:\\Users\\dmdsj\\Algorithm\\src\\com\\company\\huffmanRunlength/sample.txt", "r");
        app.compressFile(file, "sample.txt");
        file.close();


    }

    private void compressFile(RandomAccessFile fileIn, String fileName) throws IOException {

        String outFileName = fileName + ".z";

        RandomAccessFile fileOut = new RandomAccessFile(outFileName, "rw");

        collectRuns(fileIn);
        outputFrequencies(fileIn, fileOut);
        createHuffmanTree();
        //printHuffmanTree();
        assignCodewords(theRoot, 0, 0);
        storeRunsIntoArray(theRoot);
    }

    private void outputFrequencies(RandomAccessFile fileIn, RandomAccessFile fileOut) throws IOException {

        fileOut.write(runList.size());
        fileOut.writeLong(fileIn.getFilePointer());

        for (Run run : runList) {
            fileOut.write(run.getSymbol());
            fileOut.writeInt(run.getLength());
            fileOut.writeInt(run.getFrequency());
        }
    }

    private void storeRunsIntoArray(Run run) {
        if (run.left == null && run.right == null) {
            insertToArray(run);
        } else if (run.left != null) {
            storeRunsIntoArray(run.left);
        } else {
            storeRunsIntoArray(run.right);
        }
    }

    public Run findRun(byte symbol, int length) {
        Run run = chars[symbol];
        while (run != null) {
            if (run.getLength() == length) {
                return run;
            }
            run = run.right;
        }

        throw new NullPointerException();
    }

    private void insertToArray(Run run) {
        int index = run.getSymbol();
        run.right = chars[index].right;
        chars[index].right = run;
    }

    private void assignCodewords(Run run, int codeword, int length) {
        if (run.right == null && run.left == null) {
            run.codeword = codeword;
            run.codewordLen = length;
            int getCodeword = Integer.parseInt(Integer.toBinaryString(codeword));
            String codeWordString = String.format("%0" + length + "d", getCodeword);
            System.out.println(codeWordString);
        } else {
            assignCodewords(run.left, codeword << 1, length + 1);
            assignCodewords(run.right, (codeword << 1) + 1, length + 1);
        }
    }

}

