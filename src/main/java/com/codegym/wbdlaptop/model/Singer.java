package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "singer")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSinger;
    //    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate birthday;
    private String birthday;
    @Lob
    private String information;
    private String avatarSinger;
    private String gender;
    private String createBy;
    @ManyToOne
    User user;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_song" ,
            joinColumns = @JoinColumn(name = "singer_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songList;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_player" ,
            joinColumns = @JoinColumn(name = "singer_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Playlist> playlists;

    public Singer() {
    }

    public Singer(Long id, String nameSinger, String birthday, String information, String avatarSinger, String gender, String createBy, User user, List<Song> songList, List<Playlist> playlists) {
        this.id = id;
        this.nameSinger = nameSinger;
        this.birthday = birthday;
        this.information = information;
        this.avatarSinger = avatarSinger;
        this.gender = gender;
        this.createBy = createBy;
        this.user = user;
        this.songList = songList;
        this.playlists = playlists;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAvatarSinger() {
        return avatarSinger;
    }

    public void setAvatarSinger(String avatarSinger) {
        this.avatarSinger = avatarSinger;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
