.class public init
.field public aaa I
.method static public main([Ljava/lang/String;)V
.limit locals 3
ldc 1
ldc 2
invokevirtual init/hi(I)I
isum
aload_0
getfield aaa/1
if_icmpge LABEL1
iconst_1
goto LABEL2
LABEL1: iconst_0
LABEL2: istore 2
.end method
.method public hi(I)I
.limit locals 2
.end method
