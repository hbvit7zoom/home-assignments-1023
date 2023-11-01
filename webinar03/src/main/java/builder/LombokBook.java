package builder;

import lombok.*;

@Builder
@ToString
@Setter
//@Getter
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LombokBook {

    public String author;
    public String title;

    public static void main(String[] args) {
        LombokBook build = LombokBook.builder()
                .author("Пушкин")
                .title("Капитанская дочка")
                .build();
    }
}
