package com.pgssoftware.either;

import io.vavr.control.Either;

public class EitherExample {





    public Long processWithEither(long id) {

        return successOrFailureWithEither(id)
                .peekLeft(System.out::println)
                .right()
                .map(v -> {
                    if (v < 10) {
                        return Long.valueOf("0"); //tuned right result
                    } else {
                        return v;
                    }
                })
                .getOrElse(Long.valueOf("123")); //default
    }


    private Either<String, Long> successOrFailureWithEither(long id) {
        if (id > 10) {
            return Either.left("NOT_FOUND");
        } else {
            return Either.right(id);
        }
    }
}
