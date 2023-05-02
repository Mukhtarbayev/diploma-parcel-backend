package diploma.backend.parcel.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileModel {
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        private String id;
        private Long userId;
        private String type;
        @Lob
        private byte[] data;

        public FileModel(Long userId, String type, byte[] data) {
                this.userId = userId;
                this.type = type;
                this.data = data;
        }
}
