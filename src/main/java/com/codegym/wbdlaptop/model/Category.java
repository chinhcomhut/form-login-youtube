package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategory;
    private String avatarCategory;
    private String createBy;
    @ManyToOne
    User user;
    //    @JsonBackReference
//    @JsonManagedReference //lop Category la lop bo cua Song nen chon Managed
//@JsonIgnore
//  @JsonIgnore
//    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_song" ,
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songList;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_player" ,
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists;

    public Category() {
    }

    public Category(Long id, String nameCategory, String avatarCategory, String createBy, User user, List<Song> songList, List<Playlist> playlists) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.avatarCategory = avatarCategory;
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

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getAvatarCategory() {
        return avatarCategory;
    }

    public void setAvatarCategory(String avatarCategory) {
        this.avatarCategory = avatarCategory;
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