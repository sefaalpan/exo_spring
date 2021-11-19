package be.ros.spring_panier_exo.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user_items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserItemsEmbeddableWay {

    @EmbeddedId
    private UserItemsIdKey userItemId;

    @Column(nullable=false)
    private int quantity;

    @Embeddable
    public class UserItemsIdKey implements Serializable {

        @ManyToOne
        @JoinColumn(name = "userId")
        private User user;

        @ManyToOne
        @JoinColumn(name = "itemId")
        private Item item;

    }

}
