package add.mode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter//авто гетер
@Setter//авто сетер
@ToString
@Table(name ="hz")
@NoArgsConstructor//пустой коснтруктор
@AllArgsConstructor//конструктор со всеми полями класса
public class Device {
    private Long id;
    @Column(name = "...")
    private String name;
}
