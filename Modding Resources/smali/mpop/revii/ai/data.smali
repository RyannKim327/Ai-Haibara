.class public Lmpop/revii/ai/data;
.super Ljava/lang/Object;
.source "data.java"


# static fields
.field public static pack:[I


# direct methods
.method static final constructor <clinit>()V
    .locals 1

    const/16 v0, 0x11

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lmpop/revii/ai/data;->pack:[I

    return-void

    :array_0
    .array-data 4
        0x103
        0x398
        0x19e
        0x442
        0x4d0
        0x534
        0x620
        0x2e0
        0x804
        0x7e4
        0xa24
        0x9d8
        0x89d
        0x450
        0xa3b
        0xc4e
        0x5ee
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
