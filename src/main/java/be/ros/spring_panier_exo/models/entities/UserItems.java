// package be.ros.spring_panier_exo.models.entities;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import lombok.experimental.FieldDefaults;

// @Entity
// @Table
// @NoArgsConstructor
// @AllArgsConstructor
// @FieldDefaults(level = AccessLevel.PRIVATE)
// public class UserItems {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     Long userItemId;

//     @ManyToOne
//     @JoinColumn(name = "userId")
//     User user;

//     @ManyToOne
//     @JoinColumn(name = "itemId")
//     Item item;

//     @Column(nullable = false)
//     int quantity;
// }
