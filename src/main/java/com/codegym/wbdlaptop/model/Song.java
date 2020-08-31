package com.codegym.wbdlaptop.model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSinger;
    private String nameCategory;
    private String nameBand;
    private String nameSong;
    private String avatarSong;
    private String mp3Url;
    private String nameCategoryTest;
    @Lob
    private String lyrics;
    private String createBy;
    private int likeSong;
    private int listenSong;
    @ManyToOne
    User user;

    public Song() {
    }

    public Song(Long id, String nameSinger, String nameCategoryTest,String nameCategory, String nameBand, String nameSong, String avatarSong, String mp3Url, String lyrics, String createBy, int likeSong, int listenSong, User user) {
        this.id = id;
        this.nameSinger = nameSinger;
        this.nameCategory = nameCategory;
        this.nameBand = nameBand;
        this.nameSong = nameSong;
        this.avatarSong = avatarSong;
        this.mp3Url = mp3Url;
        this.lyrics = lyrics;
        this.createBy = createBy;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.user = user;
        this.nameCategoryTest = nameCategoryTest;
    }

    public String getNameCategoryTest() {
        return nameCategoryTest;
    }

    public void setNameCategoryTest(String nameCategoryTest) {
        this.nameCategoryTest = nameCategoryTest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getAvatarSong() {
        return avatarSong;
    }

    public void setAvatarSong(String avatarSong) {
        this.avatarSong = avatarSong;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(int likeSong) {
        this.likeSong = likeSong;
    }

    public int getListenSong() {
        return listenSong;
    }

    public void setListenSong(int listenSong) {
        this.listenSong = listenSong;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
