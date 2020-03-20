import org.junit.Test;
import org.graalvm.compiler.debug.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestVisitor {

       @Test
        public void save() throws IOException {
           Visitor visitor =new Visitor("Thapelo Mabuza", 15,"18-Mar-2020",
                   "23:25","No comment", "Bruce");

//        Assertions.assertThrows(IOException.class, () -> visitor.save(){
//            ;});
        }

        @Test
        public void load()throws  IOException{
        Visitor visitor =new Visitor("Thapelo Mabuza", 15,"18-Mar-2020",
                "23:25","No comment", "Bruce");
//      Assertions.assertThrows(IOException.class, () -> visitor.load("Thapelo Mabuza");
//
        }
    }


