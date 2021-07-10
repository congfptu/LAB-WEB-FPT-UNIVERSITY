/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author congfptu
 */
public class Answer {
     private String id;
    private String content;
    private boolean isTrue;

    public Answer() {
    }

    public Answer(String id,String content, boolean isTrue) {
        this.id = id;
        this.content = content;
        this.isTrue = isTrue;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
        
}
