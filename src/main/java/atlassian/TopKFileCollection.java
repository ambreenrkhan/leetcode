package atlassian;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2. Design a file tag system or voting system.
 *  - Given a list of files with multiple tags associated with them, group the files based on tags and return a list of top tags based on total file size.
 */
@Slf4j
public class TopKFileCollection {
    Map<String,FileCollection> fileCollectionsByName = new HashMap<>();
    Map<String,FileObj> files = new HashMap<>();

    public void addFile(String fileName, long fileSize, String... collections){
        FileObj fileObj = files.computeIfAbsent(fileName, k-> new FileObj(fileName, fileSize));

        for(String collection: collections){
            FileCollection currentCollection = fileCollectionsByName.computeIfAbsent(collection, k-> new FileCollection(collection));
            currentCollection.addFile(fileObj.fileName);
        }

    }

    public long totalSize(){
        return files.values().stream().mapToLong(f->f.size).sum();
    }

    public List<String> getTopK(int k){

        return fileCollectionsByName.entrySet().stream().sorted(Map.Entry.comparingByValue(new FileComparator(files))).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static class FileObj{
         String fileName;
         long size;

         public FileObj(String fileName, long size){
             this.fileName = fileName;
             this.size = size;
         }
    }

    public static class FileCollection{
        String collectionName;
        List<String> files = new ArrayList<>();

        public FileCollection(String collectionName){
            this.collectionName = collectionName;
        }

        public void addFile(String file){
            files.add(file);
        }
    }

    public static class FileComparator implements Comparator<FileCollection> {
        Map<String,FileObj> files;
        public FileComparator(Map<String,FileObj> files){
            this.files = files;

        }

        @Override
        public int compare(FileCollection x, FileCollection y){
          Long xSize = x.files.stream().mapToLong(k->files.get(k).size).sum();
          Long ySize = y.files.stream().mapToLong(k->files.get(k).size).sum();

          return ySize.compareTo(xSize);
        }
    }


    public static void main(String args[]){
        TopKFileCollection collec = new TopKFileCollection();

        collec.addFile("file1.txt", 100);
        collec.addFile("file2.txt", 100,"collection1");
        collec.addFile("file3.txt", 200,"collection1");
        collec.addFile("file4.txt", 300, "collection3");
        collec.addFile("file5.txt", 400, "collection4");
        log.info(collec.totalSize()+""); //output 1100
        log.info(collec.getTopK(2).toString());

    }





}
