package edu.jsp.ak.Dto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class NewsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String heading;
    
    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String paragraph;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] compressedImageData;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at") // Custom name for the column
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public byte[] getCompressedImageData() {
        return compressedImageData;
    }

    public void setCompressedImageData(byte[] compressedImageData) {
        this.compressedImageData = compressedImageData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @PrePersist
    protected void onCreate() {
        System.out.println("PrePersist method called"); // Add this line for debugging
        createdAt = new Date(); // Set the creation date and time
    }

    public byte[] getImageData() throws IOException {
        if (compressedImageData == null) {
            return null;
        }

        Inflater inflater = new Inflater();
        inflater.setInput(compressedImageData);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedImageData.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            try {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        outputStream.close();
        byte[] decompressedData = outputStream.toByteArray();
        inflater.end();

        return decompressedData;
    }

    public void setImageData(byte[] imageData) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(imageData);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageData.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] compressedData = outputStream.toByteArray();
        deflater.end();

        this.compressedImageData = compressedData;
    }

    @Override
    public String toString() {
        return "NewsData [id=" + id + ", heading=" + heading + ", paragraph=" + paragraph + ", compressedImageData="
                + Arrays.toString(compressedImageData) + ", createdAt=" + createdAt + "]";
    }
}
