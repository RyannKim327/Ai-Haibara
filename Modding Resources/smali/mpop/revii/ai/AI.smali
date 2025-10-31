.class public Lmpop/revii/ai/AI;
.super Landroid/widget/RelativeLayout;
.source "AI.java"

# interfaces
.implements Landroid/speech/tts/TextToSpeech$OnInitListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmpop/revii/ai/AI$100000000;,
        Lmpop/revii/ai/AI$100000002;,
        Lmpop/revii/ai/AI$100000003;,
        Lmpop/revii/ai/AI$100000005;,
        Lmpop/revii/ai/AI$100000007;,
        Lmpop/revii/ai/AI$100000008;,
        Lmpop/revii/ai/AI$100000009;,
        Lmpop/revii/ai/AI$100000011;,
        Lmpop/revii/ai/AI$100000012;,
        Lmpop/revii/ai/AI$100000013;,
        Lmpop/revii/ai/AI$100000014;,
        Lmpop/revii/ai/AI$100000015;
    }
.end annotation


# static fields
.field public static creator:[I

.field public static developer:[I


# instance fields
.field aichat:Ljava/lang/String;

.field aichatc:Ljava/lang/String;

.field base:Landroid/widget/LinearLayout;

.field context:Landroid/content/Context;

.field e:Landroid/widget/EditText;

.field fromcolor:Ljava/lang/String;

.field iv:Landroid/widget/ImageButton;

.field lq:Ljava/lang/String;

.field mainchatbox:Ljava/lang/String;

.field maincolor:Ljava/lang/String;

.field msg_:[I

.field replied:Z

.field sc:Landroid/widget/ScrollView;

.field sc2:Landroid/widget/LinearLayout;

.field selfchat:Ljava/lang/String;

.field selfchatc:Ljava/lang/String;

.field sp:Landroid/content/SharedPreferences;

.field sr:Landroid/speech/SpeechRecognizer;

.field tts:Landroid/speech/tts/TextToSpeech;

.field vuri:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field vuriarr:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<[",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field welcome:[I


# direct methods
.method static final constructor <clinit>()V
    .locals 1

    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lmpop/revii/ai/AI;->creator:[I

    const/16 v0, 0x2d

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Lmpop/revii/ai/AI;->developer:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x23e
        0x3c8
        0x369
        0x44c
        0x4ba
        0x384
        0x5be
        0x6d0
        0x396
        0x3e8
        0x4ba
    .end array-data

    :array_1
    .array-data 4
        0x23e
        0x3c8
        0x369
        0x44c
        0x4ba
        0x180
        0x41a
        0x690
        0x7aa
        0x280
        0x722
        0x978
        0x96f
        0x9a8
        0xc57
        0xce4
        0xce4
        0xf9c
        0x4d0
        0x400
        0xda4
        0x10e0
        0x13c4
        0x14d0
        0x460
        0x10b8
        0x302
        0x378
        0x42f
        0x44c
        0x160
        0x48c
        0x64a
        0x200
        0x5c4
        0x974
        0x856
        0xa50
        0x906
        0x708
        0xb13
        0xcc6
        0x693
        0x708
        0x604
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 87
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    const/16 v0, 0x67f

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lmpop/revii/ai/AI;->welcome:[I

    const/16 v0, 0xd8

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    iput-object v0, p0, Lmpop/revii/ai/AI;->msg_:[I

    const/4 v0, 0x1

    iput-boolean v0, p0, Lmpop/revii/ai/AI;->replied:Z

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->maincolor:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->mainchatbox:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchat:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchatc:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichat:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichatc:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->fromcolor:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->lq:Ljava/lang/String;

    .line 88
    iput-object p1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    .line 89
    invoke-virtual {p0, p1}, Lmpop/revii/ai/AI;->ai(Landroid/content/Context;)V

    return-void

    .line 87
    :array_0
    .array-data 4
        0xf5
        0x118
        0x13b
        0x140
        0x197
        0x564
        0x8c
        0x230
        0x276
        0x2bc
        0x302
        0x300
        0x309
        0xac8
        0x10e
        0x456
        0xed3
        0x168
        0x118
        0x860
        0x1008
        0xfc8
        0x1130
        0x13b0
        0xfdc
        0x11f8
        0x46
        0x150
        0x120
        0x2e4
        0x4c5
        0x4e0
        0x604
        0x200
        0x5a0
        0x794
        0xa0e
        0xa20
        0x2a0
        0x648
        0xa3b
        0xc4e
        0xd47
        0xda4
        0xc94
        0x400
        0x654
        0x9b0
        0x580
        0xc30
        0xaf0
        0xb68
        0xe0
        0x280
        0x402
        0x456
        0x512
        0x4ec
        0x578
        0x650
        0x804
        0xc8
        0x39c
        0x300
        0x651
        0x918
        0xc06
        0xc8a
        0x420
        0xa8c
        0xb0c
        0xec0
        0xec4
        0x1130
        0x580
        0xe70
        0xd43
        0x1130
        0x2a7
        0x360
        0x3e7
        0x140
        0x1ef
        0x2e8
        0x1c0
        0x410
        0x5a0
        0x5b4
        0x2c0
        0x780
        0x95a
        0xa68
        0xc72
        0xc4e
        0xce4
        0xe34
        0xc78
        0x140
        0x5e8
        0x500
        0xcb8
        0x14d0
        0xe38
        0x1130
        0xe0
        0x250
        0x38d
        0x474
        0x457
        0x51c
        0x69e
        0x200
        0x492
        0x898
        0x9f8
        0x9d8
        0x873
        0xaf8
        0xbb5
        0x3c0
        0x5cd
        0x8b8
        0x380
        0xa80
        0xe34
        0x11f8
        0x13f0
        0x12f0
        0xf96
        0x500
        0x2a7
        0x370
        0x384
        0x140
        0x34f
        0x4bc
        0x604
        0x740
        0x7ce
        0x8e8
        0xdc
        0x3f0
        0x2a0
        0x7c8
        0xa3b
        0xca8
        0xf36
        0xda4
        0xaf0
        0xde0
        0x1008
        0x500
        0x7bc
        0xba0
        0x460
        0xc08
        0x2a7
        0x390
        0x3c3
        0x3e8
        0x4c5
        0x594
        0x604
        0x200
        0x522
        0x7d0
        0x8ae
        0x918
        0xd2
        0x3f0
        0x360
        0x8ac
        0xe4f
        0xea0
        0xc08
        0x400
        0xb88
        0x1158
        0x14cc
        0x600
        0xa64
        0xf28
        0x310
        0x348
        0x384
        0x3ca
        0x160
        0x324
        0x54e
        0x6c0
        0x762
        0x884
        0x948
        0x9d8
        0x8f1
        0x300
        0x4bf
        0x744
        0x420
        0xad4
        0xa9c
        0xe40
        0xf0c
        0xfa0
        0x1314
        0x1650
        0xf0a
        0x500
        0x2a7
        0x370
        0x384
        0x140
        0x2f7
        0x528
        0x56a
        0x720
        0x882
        0x8c0
        0x9f8
        0x9d8
        0x91b
        0xa50
        0x10e
        0x4ec
        0x420
        0xb88
        0xc24
        0xdc0
        0xda4
        0x10e0
        0x1130
        0x600
        0xb7c
        0x1158
        0x31e
        0x390
        0x38d
        0x424
        0x4c5
        0x564
        0x1c0
        0x4c0
        0x762
        0x884
        0x9a0
        0x9d8
        0x7f5
        0x960
        0xbb5
        0x3c0
        0x5cd
        0x8b8
        0x380
        0x940
        0xda4
        0x1270
        0x10ac
        0x600
        0xa87
        0xfc8
        0x302
        0x3a0
        0x3e7
        0x474
        0x6e
        0x1f8
        0x1c0
        0x4a0
        0x71a
        0x8e8
        0x9e2
        0xa68
        0x906
        0x300
        0x711
        0xb5e
        0xeb2
        0xec4
        0xc08
        0x400
        0x654
        0x9b0
        0x580
        0xf60
        0xdcf
        0x1018
        0x1e3
        0x3c0
        0x5a
        0x1a4
        0x160
        0x3d8
        0x612
        0x760
        0x762
        0x7e4
        0x2c0
        0x690
        0x95a
        0x918
        0xb9a
        0xb9a
        0xd89
        0x102c
        0xad4
        0xde0
        0x480
        0x708
        0xaa8
        0x600
        0xb36
        0xfc8
        0x2d1
        0x228
        0x438
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x5d6
        0x8c0
        0x8ae
        0x978
        0x81f
        0x9c0
        0x8a6
        0xbd6
        0xcc3
        0xf9c
        0xb44
        0xdc0
        0xec4
        0x1310
        0x115c
        0x1560
        0x15e
        0x690
        0xe0
        0x298
        0x3e7
        0x4ba
        0x507
        0x528
        0x612
        0x200
        0x522
        0x8ac
        0x974
        0x300
        0x3b1
        0x5d0
        0x360
        0x924
        0xe4f
        0x480
        0x754
        0xd00
        0xda4
        0x1130
        0x11b4
        0x12f0
        0x460
        0xb68
        0x1dc
        0x398
        0x5a
        0x1a4
        0x160
        0x348
        0x612
        0x720
        0x828
        0x988
        0x932
        0x9d8
        0x849
        0x300
        0x8dc
        0xdb6
        0xe2e
        0xe34
        0xc94
        0xd60
        0xec4
        0xfc8
        0x580
        0x870
        0x87a
        0x500
        0x245
        0x340
        0x369
        0x474
        0x457
        0x4b0
        0x460
        0x720
        0x71a
        0x7f8
        0x8ae
        0xab0
        0x849
        0xa50
        0xa71
        0xbd6
        0x14a
        0x5e8
        0x380
        0xa00
        0xf9c
        0x10e0
        0x1290
        0x13b0
        0xf0a
        0xf28
        0x32c
        0x348
        0x3e7
        0x44c
        0x4f1
        0x228
        0x38e
        0x490
        0x240
        0x384
        0x554
        0x300
        0x555
        0x780
        0x7b3
        0x12c
        0x56a
        0x480
        0x914
        0xe80
        0xda4
        0x11d0
        0x13f0
        0xff0
        0xf50
        0x500
        0x27d
        0x268
        0x3e7
        0x49c
        0x483
        0x4bc
        0x516
        0x200
        0x32a
        0x4d8
        0x2c0
        0x6d8
        0x834
        0x978
        0xa3b
        0x12c
        0x56a
        0x480
        0x7c4
        0xca0
        0xf78
        0xfc8
        0x13c4
        0x13b0
        0xfb9
        0x500
        0x1ea
        0x328
        0x402
        0x44c
        0x42b
        0x528
        0x578
        0x650
        0x894
        0x280
        0x3de
        0x5d0
        0x2a0
        0x7c8
        0xbd0
        0xbd6
        0xcc3
        0xec4
        0xa9c
        0xd80
        0x480
        0xa78
        0x1398
        0x12f0
        0xdac
        0x1068
        0x32c
        0x398
        0x5a
        0x1a4
        0x160
        0x36c
        0x64a
        0x720
        0x804
        0x794
        0x8ae
        0xa20
        0x2a0
        0x780
        0xc06
        0xbd6
        0xc81
        0xf0c
        0x380
        0x5a0
        0x8b8
        0x500
        0xe44
        0x1500
        0xdcf
        0xf78
        0x2df
        0x308
        0x3cc
        0x140
        0x2e1
        0x558
        0x586
        0x640
        0x762
        0x910
        0x9e2
        0xf0
        0x372
        0x300
        0x6f6
        0xdb6
        0xe2e
        0xe10
        0xa9c
        0xe60
        0x480
        0xa28
        0x12e8
        0x12c0
        0xf96
        0x1068
        0x2a7
        0x370
        0x120
        0x1c2
        0x2aa
        0x180
        0x3d4
        0x420
        0x240
        0x53c
        0x948
        0x978
        0x7f5
        0xa50
        0x360
        0x906
        0xe4f
        0xe10
        0x118
        0x540
        0x480
        0xa78
        0x11e0
        0x1230
        0xf96
        0x10e0
        0x309
        0x390
        0x369
        0x41a
        0x46d
        0x528
        0x586
        0xa0
        0x2f4
        0x280
        0x65c
        0x918
        0x9ed
        0xac8
        0xbb5
        0xce4
        0x420
        0xc84
        0xbec
        0xc20
        0x1050
        0xf28
        0x1b8
        0x7e0
        0x460
        0xb90
        0x2a7
        0x3c8
        0x40b
        0x456
        0x4ba
        0x180
        0x3d4
        0x720
        0x6d2
        0x898
        0x882
        0x9d8
        0x96f
        0x948
        0xbb5
        0x12c
        0x56a
        0x480
        0x818
        0xde0
        0xea0
        0x1130
        0x580
        0xe70
        0xe5b
        0xf78
        0x2d8
        0x308
        0x38d
        0x438
        0x160
        0x30c
        0x63c
        0x630
        0x71a
        0x898
        0x856
        0xf0
        0x372
        0x300
        0x8dc
        0xd5c
        0xf15
        0xf9c
        0xc08
        0xce0
        0x480
        0xc08
        0x120c
        0x14d0
        0x15e
        0x690
        0xe0
        0x228
        0x369
        0x474
        0x4a4
        0x180
        0x48a
        0x680
        0x762
        0x898
        0x8ae
        0x300
        0x6cf
        0x918
        0xc8d
        0xc4e
        0xeb2
        0x168
        0x498
        0x400
        0xab0
        0xfc8
        0x13c4
        0x15c0
        0xdcf
        0x11d0
        0xe0
        0x270
        0x369
        0x49c
        0x42b
        0x558
        0x63c
        0x610
        0xb4
        0x348
        0x2c0
        0x678
        0x8dc
        0x9f0
        0xbb5
        0xc30
        0xe2e
        0x480
        0x86c
        0xde0
        0xf78
        0x1310
        0x10ac
        0x1440
        0xdcf
        0x1310
        0xe0
        0x268
        0x369
        0x406
        0x4c5
        0x78
        0x24c
        0x200
        0x4b6
        0x870
        0x856
        0xab0
        0x8c7
        0x300
        0x6f6
        0xb5e
        0xe2e
        0xe10
        0xb7c
        0xde0
        0xf30
        0xf28
        0x580
        0xd50
        0xfff
        0x1068
        0x302
        0x3a0
        0x3e7
        0x64
        0x1ce
        0x180
        0x3b8
        0x720
        0x7ce
        0x834
        0x898
        0x738
        0x91b
        0x960
        0xb13
        0xbf4
        0xd89
        0xdec
        0xa9c
        0xe80
        0xf9c
        0x11d0
        0x13c4
        0x1e0
        0x5be
        0x500
        0x230
        0x348
        0x3de
        0x456
        0x533
        0x330
        0x586
        0x6e0
        0xb4
        0x348
        0x2c0
        0x840
        0x594
        0x618
        0x4bf
        0x7f8
        0xd05
        0x1098
        0xb0c
        0xd80
        0xf9c
        0x1180
        0x115c
        0x1560
        0xfb9
        0x190
        0x126
        0x100
        0x2d0
        0x41a
        0x4ba
        0x570
        0x586
        0x720
        0x71a
        0x8fc
        0x9f8
        0xf0
        0x372
        0x300
        0x8c1
        0xe2e
        0xe0d
        0xdc8
        0xb7c
        0xc20
        0xf78
        0x1068
        0x14f8
        0x12f0
        0x15e
        0x190
        0x1b2
        0x100
        0x2f4
        0x410
        0x457
        0x558
        0x586
        0x200
        0x6d2
        0x8e8
        0x8ae
        0x300
        0x81f
        0x9c0
        0xa3b
        0xce4
        0xd47
        0xe34
        0xc94
        0x400
        0xea0
        0xf28
        0x1340
        0x1500
        0xdcf
        0x1130
        0x2c3
        0x320
        0x18c
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x828
        0x820
        0x8ae
        0x300
        0x81f
        0xa68
        0xb7f
        0xcc6
        0xc81
        0xf78
        0xaf0
        0xe60
        0x480
        0x1298
        0x10ac
        0x1590
        0x460
        0xf78
        0x2d8
        0x308
        0x3de
        0x406
        0x457
        0x4b0
        0x1c0
        0x660
        0x7ce
        0x8e8
        0x2c0
        0xb58
        0x91b
        0xaf8
        0x360
        0xd98
        0xe4f
        0x480
        0xbec
        0xc20
        0xf0c
        0xfc8
        0x580
        0x16b0
        0xf2d
        0x1248
        0x31e
        0x100
        0x37b
        0x456
        0x4ba
        0x4c8
        0x5be
        0x670
        0x83a
        0x8e8
        0x856
        0xae0
        0x89d
        0xa68
        0xb9a
        0xd7a
        0x420
        0xe34
        0xa9c
        0xe60
        0xec4
        0xfc8
        0x1398
        0x8a0
        0x460
        0xd20
        0x2d8
        0x328
        0x120
        0x3de
        0x4c5
        0x51c
        0x5f6
        0x610
        0x7bc
        0x7d0
        0x9e2
        0x300
        0x96f
        0xae0
        0xa3b
        0xd5c
        0xef4
        0x102c
        0x380
        0xee0
        0xec4
        0x1220
        0x11e0
        0x600
        0xd43
        0x500
        0x2b5
        0x378
        0x3cc
        0x456
        0x4ba
        0x180
        0x24c
        0x2a0
        0x414
        0x348
        0x39c
        0x450
        0x2a0
        0x7e0
        0xaf8
        0xbd6
        0x420
        0xdec
        0xc24
        0xda0
        0xf54
        0xf28
        0x12e8
        0x12c0
        0xfb9
        0x500
        0x2ae
        0x328
        0x3cc
        0x456
        0x51d
        0x180
        0x54e
        0x720
        0x71a
        0x280
        0x9f8
        0x9c0
        0x849
        0x300
        0xbd0
        0xd5c
        0xd05
        0xe58
        0xb0c
        0xe40
        0xe34
        0x1130
        0x1104
        0x12f0
        0xfb9
        0x500
        0x34f
        0x378
        0x41d
        0x140
        0x4af
        0x48c
        0x69e
        0x200
        0x83a
        0x8fc
        0x8ae
        0x570
        0xd2
        0x3f0
        0x360
        0xb40
        0x56a
        0x5e8
        0x658
        0xe00
        0x1008
        0xfc8
        0x1188
        0x12f0
        0xf96
        0xfc8
        0x302
        0x318
        0x38d
        0x47e
        0x1ce
        0x1f8
        0x540
        0x200
        0x32a
        0x280
        0x738
        0x9c0
        0x89d
        0xac8
        0x360
        0xb9a
        0xe4f
        0xf54
        0xbec
        0xc20
        0xf78
        0xfa0
        0x580
        0x1650
        0xe5b
        0x10e0
        0x2f4
        0x100
        0x3f0
        0x456
        0x4d0
        0x57c
        0x620
        0x200
        0x828
        0x820
        0x8ae
        0x300
        0x81f
        0xa68
        0xb9a
        0xbf4
        0xd89
        0xe7c
        0xccc
        0xe40
        0xda4
        0x1220
        0x120c
        0x14d0
        0xf0a
        0x6e0
        0xe0
        0x330
        0x3e7
        0x474
        0x160
        0x5ac
        0x612
        0x750
        0x240
        0x910
        0x98a
        0x300
        0x8f1
        0x918
        0xb49
        0xbd6
        0x420
        0xec4
        0xcb0
        0x400
        0xe34
        0xf28
        0x13c4
        0x13b0
        0xdcf
        0x11d0
        0xe0
        0x3a0
        0x3e7
        0x140
        0x507
        0x564
        0x586
        0x2e0
        0xb4
        0x348
        0x2c0
        0x900
        0x372
        0x3f0
        0x61e
        0xbf4
        0xd05
        0xe34
        0xaf0
        0xc40
        0xda4
        0xf78
        0x1264
        0x7e0
        0x5be
        0xf00
        0xe0
        0x168
        0x120
        0x33e
        0x483
        0x528
        0x56a
        0x650
        0x240
        0x94c
        0x8ae
        0x300
        0x9c3
        0x918
        0xb9a
        0xd98
        0x420
        0x1050
        0xc24
        0x400
        0xf54
        0xf28
        0x1264
        0x12f0
        0x460
        0x11f8
        0x309
        0x368
        0x38d
        0x140
        0x483
        0x51c
        0x620
        0x720
        0x7ce
        0x938
        0x8ae
        0xa38
        0x849
        0xa50
        0xc3c
        0x528
        0x420
        0x1104
        0xc24
        0xea0
        0x480
        0x1108
        0x10ac
        0x16b0
        0x460
        0x11f8
        0x2c3
        0x370
        0x384
        0x140
        0x533
        0x534
        0x666
        0x720
        0x240
        0x7f8
        0x8ae
        0x978
        0x834
        0x930
        0xa3b
        0xb9a
        0xdcb
        0x480
        0xcb0
        0xde0
        0x480
        0x1248
        0x13c4
        0x8a0
        0x15e
        0x690
        0xe0
        0x300
        0x17a
        0x1a4
        0x27e
        0x4a4
        0x5e8
        0x730
        0x2f4
        0x348
        0x840
        0x300
        0x91b
        0xab0
        0x360
        0xb40
        0x56a
        0x5e8
        0x658
        0xc60
        0xf30
        0xfc8
        0x10ac
        0x1560
        0x5be
        0x690
        0x2a0
        0x100
        0x195
        0x140
        0x39c
        0x534
        0x1c0
        0x630
        0x798
        0x7e4
        0x856
        0xab0
        0x2a0
        0xae0
        0xaf8
        0xbd6
        0x420
        0xfc0
        0xa9c
        0xe60
        0x1050
        0x500
        0x12bc
        0x12f0
        0xfb9
        0x11f8
        0x2a7
        0x338
        0x38d
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x828
        0x8ac
        0x2c0
        0x948
        0x95a
        0x978
        0xa3b
        0xd98
        0xd05
        0x480
        0xa9c
        0x400
        0xf78
        0xfc8
        0x1474
        0x600
        0xd89
        0x1158
        0x302
        0x3b0
        0x38d
        0x474
        0x4f1
        0x48c
        0x658
        0x690
        0x7ce
        0x898
        0xdc
        0x3f0
        0x2a0
        0x900
        0x46e
        0x4ec
        0x77a
        0x102c
        0xc40
        0xca0
        0xe34
        0xf78
        0x11e0
        0x7e0
        0x5be
        0xf00
        0xe0
        0x168
        0x120
        0x348
        0x4c5
        0x180
        0x658
        0x6f0
        0x73e
        0x80c
        0x948
        0x978
        0x2a0
        0xae0
        0xaf8
        0xbd6
        0x420
        0x1050
        0xb0c
        0xf00
        0x1050
        0x500
        0x13f0
        0x14d0
        0x460
        0x11f8
        0x310
        0x328
        0x38d
        0x3de
        0x478
        0x180
        0x54e
        0x6e0
        0x708
        0x280
        0x9e2
        0xa80
        0x849
        0x978
        0xa71
        0xc30
        0x420
        0x1050
        0xc24
        0x400
        0x1050
        0xfc8
        0x14a0
        0x15c0
        0x460
        0x11d0
        0x2c3
        0x318
        0x3e7
        0x406
        0x4ba
        0x4ec
        0x658
        0x690
        0x7ce
        0x898
        0x3f4
        0xf0
        0xd2
        0x5d0
        0x360
        0x9d8
        0xd68
        0xe34
        0x380
        0xc80
        0xe34
        0x1270
        0x115c
        0x1440
        0xf2d
        0x1180
        0x2fb
        0x328
        0x3de
        0x488
        0x160
        0x4ec
        0x64a
        0x200
        0x816
        0x910
        0x906
        0xa20
        0x8dc
        0x300
        0xb13
        0xce4
        0x420
        0xfc0
        0xc78
        0xde0
        0xe7c
        0x11d0
        0x115c
        0x1590
        0xfb9
        0x6e0
        0xe0
        0x398
        0x3f0
        0x3f2
        0x441
        0x4ec
        0x54e
        0x6c0
        0x798
        0x974
        0x2c0
        0xae0
        0x888
        0x978
        0x360
        0x79e
        0x969
        0x480
        0xb7c
        0xe60
        0x480
        0x11f8
        0x13f0
        0x13b0
        0xec4
        0x10e0
        0xe0
        0x348
        0x3de
        0x140
        0x44c
        0x4bc
        0x674
        0x650
        0x798
        0x8ac
        0x9a0
        0xa38
        0x849
        0xa50
        0xc3c
        0x564
        0x420
        0xc3c
        0xb0c
        0x400
        0xe58
        0x11d0
        0x1314
        0x1470
        0x460
        0x1220
        0x2d8
        0x328
        0x120
        0x2a8
        0x4e6
        0x534
        0x5be
        0x640
        0x56a
        0x8ac
        0x898
        0x9d8
        0x85e
        0xac8
        0x360
        0xb5e
        0xe2e
        0xe10
        0x380
        0x9a0
        0xb40
        0xc58
        0xdc0
        0x600
        0xb36
        0xfc8
        0x33a
        0x328
        0x402
        0x47e
        0x457
        0x180
        0x3fe
        0x490
        0x240
        0x94c
        0x98a
        0xaf8
        0x8dc
        0x960
        0x360
        0xca8
        0xd89
        0xf0c
        0xb0c
        0x400
        0x1050
        0x1158
        0x580
        0x12f0
        0x1068
        0x1180
        0x31e
        0x328
        0x40b
        0x47e
        0x160
        0x534
        0x666
        0x720
        0x240
        0x80c
        0x9cc
        0x918
        0x984
        0x9d8
        0xc3c
        0xdb6
        0xce4
        0xe34
        0x380
        0xe80
        0xf9c
        0x500
        0x14cc
        0x14d0
        0xfff
        0x500
        0x2ca
        0x378
        0x402
        0x140
        0x4f1
        0x57c
        0x620
        0x700
        0x7ce
        0x8e8
        0x9f8
        0x9d8
        0x906
        0x9a8
        0x360
        0xdb6
        0xed3
        0x630
        0x380
        0xe80
        0xea0
        0xfc8
        0x580
        0x12c0
        0xdcf
        0x1270
        0x2c3
        0x360
        0x3e7
        0x460
        0x457
        0x558
        0x64a
        0x200
        0x6d2
        0x898
        0x898
        0x300
        0x984
        0x9c0
        0xaa7
        0x3c0
        0xe0d
        0xf9c
        0xaf0
        0xc80
        0xe34
        0x11d0
        0x13c4
        0x600
        0xf2d
        0xff0
        0xe0
        0x3a0
        0x3a8
        0x41a
        0x4f1
        0x180
        0x54e
        0x700
        0x7e0
        0x870
        0x906
        0x948
        0x7f5
        0xae0
        0xb13
        0xd02
        0xe2e
        0x678
        0x380
        0x900
        0xf9c
        0x1180
        0x120c
        0x14a0
        0xe15
        0x500
        0x34f
        0x378
        0x41d
        0x140
        0x457
        0x528
        0x5cc
        0x6f0
        0x882
        0x280
        0xa0e
        0xac8
        0x89d
        0xa50
        0xadd
        0x3c0
        0xef4
        0xea0
        0xb7c
        0xe60
        0x678
        0x190
        0x1b8
        0xcc0
        0xdcf
        0x1270
        0x2c3
        0x360
        0x3e7
        0x460
        0x457
        0x4b0
        0x1c0
        0x620
        0x882
        0x280
        0x39c
        0x3f0
        0x6ba
        0xb58
        0xa3b
        0xce4
        0xe2e
        0xa8c
        0xb7c
        0xda0
        0x72c
        0x7d0
        0x974
        0x7e0
        0x5be
    .end array-data

    :array_1
    .array-data 4
        0x24c
        0x340
        0x369
        0x44c
        0x499
        0x180
        0x69e
        0x6f0
        0x83a
        0x280
        0x8c4
        0xa68
        0x95a
        0x300
        0xc57
        0xd7a
        0xd89
        0xf78
        0xb44
        0x400
        0x1050
        0x1040
        0x120c
        0x1590
        0x460
        0xf28
        0x310
        0x380
        0x3cc
        0x41a
        0x441
        0x48c
        0x658
        0x690
        0x7ce
        0x898
        0x3c8
        0x300
        0x5fd
        0x300
        0xaf8
        0xd02
        0xe70
        0xe34
        0x380
        0xe80
        0xea0
        0x1068
        0x13c4
        0x600
        0xee7
        0xf28
        0x34f
        0x100
        0x3a8
        0x3f2
        0x4a4
        0x540
        0x1c0
        0x790
        0x7ce
        0x924
        0x2c0
        0xae0
        0x91b
        0x300
        0xc21
        0xd98
        0xf15
        0xe10
        0xd3c
        0x400
        0xda4
        0x1130
        0x1130
        0x600
        0xdcf
        0x12c0
        0x310
        0x360
        0x3e7
        0x474
        0x457
        0x228
        0x1c0
        0x490
        0x72c
        0x280
        0xa66
        0xa68
        0x999
        0x300
        0xc8d
        0xb5e
        0xe2e
        0x1050
        0x380
        0xe80
        0xf9c
        0x500
        0x141c
        0x1590
        0xdcf
        0x500
        0x32c
        0x340
        0x3b1
        0x47e
        0x160
        0x48c
        0x64a
        0x200
        0x72c
        0x7e4
        0x856
        0xae0
        0x999
        0xab0
        0xaa7
        0x3c0
        0xe4f
        0xe58
        0x380
        0xf20
        0xf9c
        0x1248
        0x1398
        0x600
        0xd43
        0x1180
        0x310
        0x160
        0x120
        0x42e
        0x483
        0x528
        0x578
        0x6c0
        0x882
        0x280
        0x856
        0xb10
        0x91b
        0x9d8
        0xa8c
        0x3c0
        0xcc3
        0xea0
        0xa9c
        0xdc0
        0xe7c
        0x1068
        0x12e8
        0x1350
        0x460
        0x1220
        0x2d8
        0x328
        0x120
        0x3de
        0x4e6
        0x4bc
        0x578
        0x690
        0x828
        0x8fc
        0x3c8
        0x300
        0x7f5
        0xac8
        0x360
        0xd5c
        0xd05
        0x102c
        0xc40
        0xca0
        0xdec
        0x1220
        0x580
        0x15c0
        0xf2d
        0x500
        0x32c
        0x340
        0x38d
        0x140
        0x44c
        0x4bc
        0x674
        0x650
        0x798
        0x8ac
        0x9a0
        0x978
        0x95a
        0x300
        0xbb5
        0xbf4
        0x420
        0x1050
        0xb60
        0xd20
        0x102c
        0x500
        0x10ac
        0x1500
        0xf50
        0x10e0
        0x2df
        0x318
        0x369
        0x488
        0x483
        0x534
        0x604
        0x2e0
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/16 v0, 0x67f

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lmpop/revii/ai/AI;->welcome:[I

    const/16 v0, 0xd8

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    iput-object v0, p0, Lmpop/revii/ai/AI;->msg_:[I

    const/4 v0, 0x1

    iput-boolean v0, p0, Lmpop/revii/ai/AI;->replied:Z

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->maincolor:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->mainchatbox:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchat:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchatc:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichat:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichatc:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->fromcolor:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/AI;->lq:Ljava/lang/String;

    .line 94
    iput-object p1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    .line 95
    invoke-virtual {p0, p1}, Lmpop/revii/ai/AI;->ai(Landroid/content/Context;)V

    return-void

    .line 93
    :array_0
    .array-data 4
        0xf5
        0x118
        0x13b
        0x140
        0x197
        0x564
        0x8c
        0x230
        0x276
        0x2bc
        0x302
        0x300
        0x309
        0xac8
        0x10e
        0x456
        0xed3
        0x168
        0x118
        0x860
        0x1008
        0xfc8
        0x1130
        0x13b0
        0xfdc
        0x11f8
        0x46
        0x150
        0x120
        0x2e4
        0x4c5
        0x4e0
        0x604
        0x200
        0x5a0
        0x794
        0xa0e
        0xa20
        0x2a0
        0x648
        0xa3b
        0xc4e
        0xd47
        0xda4
        0xc94
        0x400
        0x654
        0x9b0
        0x580
        0xc30
        0xaf0
        0xb68
        0xe0
        0x280
        0x402
        0x456
        0x512
        0x4ec
        0x578
        0x650
        0x804
        0xc8
        0x39c
        0x300
        0x651
        0x918
        0xc06
        0xc8a
        0x420
        0xa8c
        0xb0c
        0xec0
        0xec4
        0x1130
        0x580
        0xe70
        0xd43
        0x1130
        0x2a7
        0x360
        0x3e7
        0x140
        0x1ef
        0x2e8
        0x1c0
        0x410
        0x5a0
        0x5b4
        0x2c0
        0x780
        0x95a
        0xa68
        0xc72
        0xc4e
        0xce4
        0xe34
        0xc78
        0x140
        0x5e8
        0x500
        0xcb8
        0x14d0
        0xe38
        0x1130
        0xe0
        0x250
        0x38d
        0x474
        0x457
        0x51c
        0x69e
        0x200
        0x492
        0x898
        0x9f8
        0x9d8
        0x873
        0xaf8
        0xbb5
        0x3c0
        0x5cd
        0x8b8
        0x380
        0xa80
        0xe34
        0x11f8
        0x13f0
        0x12f0
        0xf96
        0x500
        0x2a7
        0x370
        0x384
        0x140
        0x34f
        0x4bc
        0x604
        0x740
        0x7ce
        0x8e8
        0xdc
        0x3f0
        0x2a0
        0x7c8
        0xa3b
        0xca8
        0xf36
        0xda4
        0xaf0
        0xde0
        0x1008
        0x500
        0x7bc
        0xba0
        0x460
        0xc08
        0x2a7
        0x390
        0x3c3
        0x3e8
        0x4c5
        0x594
        0x604
        0x200
        0x522
        0x7d0
        0x8ae
        0x918
        0xd2
        0x3f0
        0x360
        0x8ac
        0xe4f
        0xea0
        0xc08
        0x400
        0xb88
        0x1158
        0x14cc
        0x600
        0xa64
        0xf28
        0x310
        0x348
        0x384
        0x3ca
        0x160
        0x324
        0x54e
        0x6c0
        0x762
        0x884
        0x948
        0x9d8
        0x8f1
        0x300
        0x4bf
        0x744
        0x420
        0xad4
        0xa9c
        0xe40
        0xf0c
        0xfa0
        0x1314
        0x1650
        0xf0a
        0x500
        0x2a7
        0x370
        0x384
        0x140
        0x2f7
        0x528
        0x56a
        0x720
        0x882
        0x8c0
        0x9f8
        0x9d8
        0x91b
        0xa50
        0x10e
        0x4ec
        0x420
        0xb88
        0xc24
        0xdc0
        0xda4
        0x10e0
        0x1130
        0x600
        0xb7c
        0x1158
        0x31e
        0x390
        0x38d
        0x424
        0x4c5
        0x564
        0x1c0
        0x4c0
        0x762
        0x884
        0x9a0
        0x9d8
        0x7f5
        0x960
        0xbb5
        0x3c0
        0x5cd
        0x8b8
        0x380
        0x940
        0xda4
        0x1270
        0x10ac
        0x600
        0xa87
        0xfc8
        0x302
        0x3a0
        0x3e7
        0x474
        0x6e
        0x1f8
        0x1c0
        0x4a0
        0x71a
        0x8e8
        0x9e2
        0xa68
        0x906
        0x300
        0x711
        0xb5e
        0xeb2
        0xec4
        0xc08
        0x400
        0x654
        0x9b0
        0x580
        0xf60
        0xdcf
        0x1018
        0x1e3
        0x3c0
        0x5a
        0x1a4
        0x160
        0x3d8
        0x612
        0x760
        0x762
        0x7e4
        0x2c0
        0x690
        0x95a
        0x918
        0xb9a
        0xb9a
        0xd89
        0x102c
        0xad4
        0xde0
        0x480
        0x708
        0xaa8
        0x600
        0xb36
        0xfc8
        0x2d1
        0x228
        0x438
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x5d6
        0x8c0
        0x8ae
        0x978
        0x81f
        0x9c0
        0x8a6
        0xbd6
        0xcc3
        0xf9c
        0xb44
        0xdc0
        0xec4
        0x1310
        0x115c
        0x1560
        0x15e
        0x690
        0xe0
        0x298
        0x3e7
        0x4ba
        0x507
        0x528
        0x612
        0x200
        0x522
        0x8ac
        0x974
        0x300
        0x3b1
        0x5d0
        0x360
        0x924
        0xe4f
        0x480
        0x754
        0xd00
        0xda4
        0x1130
        0x11b4
        0x12f0
        0x460
        0xb68
        0x1dc
        0x398
        0x5a
        0x1a4
        0x160
        0x348
        0x612
        0x720
        0x828
        0x988
        0x932
        0x9d8
        0x849
        0x300
        0x8dc
        0xdb6
        0xe2e
        0xe34
        0xc94
        0xd60
        0xec4
        0xfc8
        0x580
        0x870
        0x87a
        0x500
        0x245
        0x340
        0x369
        0x474
        0x457
        0x4b0
        0x460
        0x720
        0x71a
        0x7f8
        0x8ae
        0xab0
        0x849
        0xa50
        0xa71
        0xbd6
        0x14a
        0x5e8
        0x380
        0xa00
        0xf9c
        0x10e0
        0x1290
        0x13b0
        0xf0a
        0xf28
        0x32c
        0x348
        0x3e7
        0x44c
        0x4f1
        0x228
        0x38e
        0x490
        0x240
        0x384
        0x554
        0x300
        0x555
        0x780
        0x7b3
        0x12c
        0x56a
        0x480
        0x914
        0xe80
        0xda4
        0x11d0
        0x13f0
        0xff0
        0xf50
        0x500
        0x27d
        0x268
        0x3e7
        0x49c
        0x483
        0x4bc
        0x516
        0x200
        0x32a
        0x4d8
        0x2c0
        0x6d8
        0x834
        0x978
        0xa3b
        0x12c
        0x56a
        0x480
        0x7c4
        0xca0
        0xf78
        0xfc8
        0x13c4
        0x13b0
        0xfb9
        0x500
        0x1ea
        0x328
        0x402
        0x44c
        0x42b
        0x528
        0x578
        0x650
        0x894
        0x280
        0x3de
        0x5d0
        0x2a0
        0x7c8
        0xbd0
        0xbd6
        0xcc3
        0xec4
        0xa9c
        0xd80
        0x480
        0xa78
        0x1398
        0x12f0
        0xdac
        0x1068
        0x32c
        0x398
        0x5a
        0x1a4
        0x160
        0x36c
        0x64a
        0x720
        0x804
        0x794
        0x8ae
        0xa20
        0x2a0
        0x780
        0xc06
        0xbd6
        0xc81
        0xf0c
        0x380
        0x5a0
        0x8b8
        0x500
        0xe44
        0x1500
        0xdcf
        0xf78
        0x2df
        0x308
        0x3cc
        0x140
        0x2e1
        0x558
        0x586
        0x640
        0x762
        0x910
        0x9e2
        0xf0
        0x372
        0x300
        0x6f6
        0xdb6
        0xe2e
        0xe10
        0xa9c
        0xe60
        0x480
        0xa28
        0x12e8
        0x12c0
        0xf96
        0x1068
        0x2a7
        0x370
        0x120
        0x1c2
        0x2aa
        0x180
        0x3d4
        0x420
        0x240
        0x53c
        0x948
        0x978
        0x7f5
        0xa50
        0x360
        0x906
        0xe4f
        0xe10
        0x118
        0x540
        0x480
        0xa78
        0x11e0
        0x1230
        0xf96
        0x10e0
        0x309
        0x390
        0x369
        0x41a
        0x46d
        0x528
        0x586
        0xa0
        0x2f4
        0x280
        0x65c
        0x918
        0x9ed
        0xac8
        0xbb5
        0xce4
        0x420
        0xc84
        0xbec
        0xc20
        0x1050
        0xf28
        0x1b8
        0x7e0
        0x460
        0xb90
        0x2a7
        0x3c8
        0x40b
        0x456
        0x4ba
        0x180
        0x3d4
        0x720
        0x6d2
        0x898
        0x882
        0x9d8
        0x96f
        0x948
        0xbb5
        0x12c
        0x56a
        0x480
        0x818
        0xde0
        0xea0
        0x1130
        0x580
        0xe70
        0xe5b
        0xf78
        0x2d8
        0x308
        0x38d
        0x438
        0x160
        0x30c
        0x63c
        0x630
        0x71a
        0x898
        0x856
        0xf0
        0x372
        0x300
        0x8dc
        0xd5c
        0xf15
        0xf9c
        0xc08
        0xce0
        0x480
        0xc08
        0x120c
        0x14d0
        0x15e
        0x690
        0xe0
        0x228
        0x369
        0x474
        0x4a4
        0x180
        0x48a
        0x680
        0x762
        0x898
        0x8ae
        0x300
        0x6cf
        0x918
        0xc8d
        0xc4e
        0xeb2
        0x168
        0x498
        0x400
        0xab0
        0xfc8
        0x13c4
        0x15c0
        0xdcf
        0x11d0
        0xe0
        0x270
        0x369
        0x49c
        0x42b
        0x558
        0x63c
        0x610
        0xb4
        0x348
        0x2c0
        0x678
        0x8dc
        0x9f0
        0xbb5
        0xc30
        0xe2e
        0x480
        0x86c
        0xde0
        0xf78
        0x1310
        0x10ac
        0x1440
        0xdcf
        0x1310
        0xe0
        0x268
        0x369
        0x406
        0x4c5
        0x78
        0x24c
        0x200
        0x4b6
        0x870
        0x856
        0xab0
        0x8c7
        0x300
        0x6f6
        0xb5e
        0xe2e
        0xe10
        0xb7c
        0xde0
        0xf30
        0xf28
        0x580
        0xd50
        0xfff
        0x1068
        0x302
        0x3a0
        0x3e7
        0x64
        0x1ce
        0x180
        0x3b8
        0x720
        0x7ce
        0x834
        0x898
        0x738
        0x91b
        0x960
        0xb13
        0xbf4
        0xd89
        0xdec
        0xa9c
        0xe80
        0xf9c
        0x11d0
        0x13c4
        0x1e0
        0x5be
        0x500
        0x230
        0x348
        0x3de
        0x456
        0x533
        0x330
        0x586
        0x6e0
        0xb4
        0x348
        0x2c0
        0x840
        0x594
        0x618
        0x4bf
        0x7f8
        0xd05
        0x1098
        0xb0c
        0xd80
        0xf9c
        0x1180
        0x115c
        0x1560
        0xfb9
        0x190
        0x126
        0x100
        0x2d0
        0x41a
        0x4ba
        0x570
        0x586
        0x720
        0x71a
        0x8fc
        0x9f8
        0xf0
        0x372
        0x300
        0x8c1
        0xe2e
        0xe0d
        0xdc8
        0xb7c
        0xc20
        0xf78
        0x1068
        0x14f8
        0x12f0
        0x15e
        0x190
        0x1b2
        0x100
        0x2f4
        0x410
        0x457
        0x558
        0x586
        0x200
        0x6d2
        0x8e8
        0x8ae
        0x300
        0x81f
        0x9c0
        0xa3b
        0xce4
        0xd47
        0xe34
        0xc94
        0x400
        0xea0
        0xf28
        0x1340
        0x1500
        0xdcf
        0x1130
        0x2c3
        0x320
        0x18c
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x828
        0x820
        0x8ae
        0x300
        0x81f
        0xa68
        0xb7f
        0xcc6
        0xc81
        0xf78
        0xaf0
        0xe60
        0x480
        0x1298
        0x10ac
        0x1590
        0x460
        0xf78
        0x2d8
        0x308
        0x3de
        0x406
        0x457
        0x4b0
        0x1c0
        0x660
        0x7ce
        0x8e8
        0x2c0
        0xb58
        0x91b
        0xaf8
        0x360
        0xd98
        0xe4f
        0x480
        0xbec
        0xc20
        0xf0c
        0xfc8
        0x580
        0x16b0
        0xf2d
        0x1248
        0x31e
        0x100
        0x37b
        0x456
        0x4ba
        0x4c8
        0x5be
        0x670
        0x83a
        0x8e8
        0x856
        0xae0
        0x89d
        0xa68
        0xb9a
        0xd7a
        0x420
        0xe34
        0xa9c
        0xe60
        0xec4
        0xfc8
        0x1398
        0x8a0
        0x460
        0xd20
        0x2d8
        0x328
        0x120
        0x3de
        0x4c5
        0x51c
        0x5f6
        0x610
        0x7bc
        0x7d0
        0x9e2
        0x300
        0x96f
        0xae0
        0xa3b
        0xd5c
        0xef4
        0x102c
        0x380
        0xee0
        0xec4
        0x1220
        0x11e0
        0x600
        0xd43
        0x500
        0x2b5
        0x378
        0x3cc
        0x456
        0x4ba
        0x180
        0x24c
        0x2a0
        0x414
        0x348
        0x39c
        0x450
        0x2a0
        0x7e0
        0xaf8
        0xbd6
        0x420
        0xdec
        0xc24
        0xda0
        0xf54
        0xf28
        0x12e8
        0x12c0
        0xfb9
        0x500
        0x2ae
        0x328
        0x3cc
        0x456
        0x51d
        0x180
        0x54e
        0x720
        0x71a
        0x280
        0x9f8
        0x9c0
        0x849
        0x300
        0xbd0
        0xd5c
        0xd05
        0xe58
        0xb0c
        0xe40
        0xe34
        0x1130
        0x1104
        0x12f0
        0xfb9
        0x500
        0x34f
        0x378
        0x41d
        0x140
        0x4af
        0x48c
        0x69e
        0x200
        0x83a
        0x8fc
        0x8ae
        0x570
        0xd2
        0x3f0
        0x360
        0xb40
        0x56a
        0x5e8
        0x658
        0xe00
        0x1008
        0xfc8
        0x1188
        0x12f0
        0xf96
        0xfc8
        0x302
        0x318
        0x38d
        0x47e
        0x1ce
        0x1f8
        0x540
        0x200
        0x32a
        0x280
        0x738
        0x9c0
        0x89d
        0xac8
        0x360
        0xb9a
        0xe4f
        0xf54
        0xbec
        0xc20
        0xf78
        0xfa0
        0x580
        0x1650
        0xe5b
        0x10e0
        0x2f4
        0x100
        0x3f0
        0x456
        0x4d0
        0x57c
        0x620
        0x200
        0x828
        0x820
        0x8ae
        0x300
        0x81f
        0xa68
        0xb9a
        0xbf4
        0xd89
        0xe7c
        0xccc
        0xe40
        0xda4
        0x1220
        0x120c
        0x14d0
        0xf0a
        0x6e0
        0xe0
        0x330
        0x3e7
        0x474
        0x160
        0x5ac
        0x612
        0x750
        0x240
        0x910
        0x98a
        0x300
        0x8f1
        0x918
        0xb49
        0xbd6
        0x420
        0xec4
        0xcb0
        0x400
        0xe34
        0xf28
        0x13c4
        0x13b0
        0xdcf
        0x11d0
        0xe0
        0x3a0
        0x3e7
        0x140
        0x507
        0x564
        0x586
        0x2e0
        0xb4
        0x348
        0x2c0
        0x900
        0x372
        0x3f0
        0x61e
        0xbf4
        0xd05
        0xe34
        0xaf0
        0xc40
        0xda4
        0xf78
        0x1264
        0x7e0
        0x5be
        0xf00
        0xe0
        0x168
        0x120
        0x33e
        0x483
        0x528
        0x56a
        0x650
        0x240
        0x94c
        0x8ae
        0x300
        0x9c3
        0x918
        0xb9a
        0xd98
        0x420
        0x1050
        0xc24
        0x400
        0xf54
        0xf28
        0x1264
        0x12f0
        0x460
        0x11f8
        0x309
        0x368
        0x38d
        0x140
        0x483
        0x51c
        0x620
        0x720
        0x7ce
        0x938
        0x8ae
        0xa38
        0x849
        0xa50
        0xc3c
        0x528
        0x420
        0x1104
        0xc24
        0xea0
        0x480
        0x1108
        0x10ac
        0x16b0
        0x460
        0x11f8
        0x2c3
        0x370
        0x384
        0x140
        0x533
        0x534
        0x666
        0x720
        0x240
        0x7f8
        0x8ae
        0x978
        0x834
        0x930
        0xa3b
        0xb9a
        0xdcb
        0x480
        0xcb0
        0xde0
        0x480
        0x1248
        0x13c4
        0x8a0
        0x15e
        0x690
        0xe0
        0x300
        0x17a
        0x1a4
        0x27e
        0x4a4
        0x5e8
        0x730
        0x2f4
        0x348
        0x840
        0x300
        0x91b
        0xab0
        0x360
        0xb40
        0x56a
        0x5e8
        0x658
        0xc60
        0xf30
        0xfc8
        0x10ac
        0x1560
        0x5be
        0x690
        0x2a0
        0x100
        0x195
        0x140
        0x39c
        0x534
        0x1c0
        0x630
        0x798
        0x7e4
        0x856
        0xab0
        0x2a0
        0xae0
        0xaf8
        0xbd6
        0x420
        0xfc0
        0xa9c
        0xe60
        0x1050
        0x500
        0x12bc
        0x12f0
        0xfb9
        0x11f8
        0x2a7
        0x338
        0x38d
        0x140
        0x42b
        0x528
        0x578
        0x200
        0x828
        0x8ac
        0x2c0
        0x948
        0x95a
        0x978
        0xa3b
        0xd98
        0xd05
        0x480
        0xa9c
        0x400
        0xf78
        0xfc8
        0x1474
        0x600
        0xd89
        0x1158
        0x302
        0x3b0
        0x38d
        0x474
        0x4f1
        0x48c
        0x658
        0x690
        0x7ce
        0x898
        0xdc
        0x3f0
        0x2a0
        0x900
        0x46e
        0x4ec
        0x77a
        0x102c
        0xc40
        0xca0
        0xe34
        0xf78
        0x11e0
        0x7e0
        0x5be
        0xf00
        0xe0
        0x168
        0x120
        0x348
        0x4c5
        0x180
        0x658
        0x6f0
        0x73e
        0x80c
        0x948
        0x978
        0x2a0
        0xae0
        0xaf8
        0xbd6
        0x420
        0x1050
        0xb0c
        0xf00
        0x1050
        0x500
        0x13f0
        0x14d0
        0x460
        0x11f8
        0x310
        0x328
        0x38d
        0x3de
        0x478
        0x180
        0x54e
        0x6e0
        0x708
        0x280
        0x9e2
        0xa80
        0x849
        0x978
        0xa71
        0xc30
        0x420
        0x1050
        0xc24
        0x400
        0x1050
        0xfc8
        0x14a0
        0x15c0
        0x460
        0x11d0
        0x2c3
        0x318
        0x3e7
        0x406
        0x4ba
        0x4ec
        0x658
        0x690
        0x7ce
        0x898
        0x3f4
        0xf0
        0xd2
        0x5d0
        0x360
        0x9d8
        0xd68
        0xe34
        0x380
        0xc80
        0xe34
        0x1270
        0x115c
        0x1440
        0xf2d
        0x1180
        0x2fb
        0x328
        0x3de
        0x488
        0x160
        0x4ec
        0x64a
        0x200
        0x816
        0x910
        0x906
        0xa20
        0x8dc
        0x300
        0xb13
        0xce4
        0x420
        0xfc0
        0xc78
        0xde0
        0xe7c
        0x11d0
        0x115c
        0x1590
        0xfb9
        0x6e0
        0xe0
        0x398
        0x3f0
        0x3f2
        0x441
        0x4ec
        0x54e
        0x6c0
        0x798
        0x974
        0x2c0
        0xae0
        0x888
        0x978
        0x360
        0x79e
        0x969
        0x480
        0xb7c
        0xe60
        0x480
        0x11f8
        0x13f0
        0x13b0
        0xec4
        0x10e0
        0xe0
        0x348
        0x3de
        0x140
        0x44c
        0x4bc
        0x674
        0x650
        0x798
        0x8ac
        0x9a0
        0xa38
        0x849
        0xa50
        0xc3c
        0x564
        0x420
        0xc3c
        0xb0c
        0x400
        0xe58
        0x11d0
        0x1314
        0x1470
        0x460
        0x1220
        0x2d8
        0x328
        0x120
        0x2a8
        0x4e6
        0x534
        0x5be
        0x640
        0x56a
        0x8ac
        0x898
        0x9d8
        0x85e
        0xac8
        0x360
        0xb5e
        0xe2e
        0xe10
        0x380
        0x9a0
        0xb40
        0xc58
        0xdc0
        0x600
        0xb36
        0xfc8
        0x33a
        0x328
        0x402
        0x47e
        0x457
        0x180
        0x3fe
        0x490
        0x240
        0x94c
        0x98a
        0xaf8
        0x8dc
        0x960
        0x360
        0xca8
        0xd89
        0xf0c
        0xb0c
        0x400
        0x1050
        0x1158
        0x580
        0x12f0
        0x1068
        0x1180
        0x31e
        0x328
        0x40b
        0x47e
        0x160
        0x534
        0x666
        0x720
        0x240
        0x80c
        0x9cc
        0x918
        0x984
        0x9d8
        0xc3c
        0xdb6
        0xce4
        0xe34
        0x380
        0xe80
        0xf9c
        0x500
        0x14cc
        0x14d0
        0xfff
        0x500
        0x2ca
        0x378
        0x402
        0x140
        0x4f1
        0x57c
        0x620
        0x700
        0x7ce
        0x8e8
        0x9f8
        0x9d8
        0x906
        0x9a8
        0x360
        0xdb6
        0xed3
        0x630
        0x380
        0xe80
        0xea0
        0xfc8
        0x580
        0x12c0
        0xdcf
        0x1270
        0x2c3
        0x360
        0x3e7
        0x460
        0x457
        0x558
        0x64a
        0x200
        0x6d2
        0x898
        0x898
        0x300
        0x984
        0x9c0
        0xaa7
        0x3c0
        0xe0d
        0xf9c
        0xaf0
        0xc80
        0xe34
        0x11d0
        0x13c4
        0x600
        0xf2d
        0xff0
        0xe0
        0x3a0
        0x3a8
        0x41a
        0x4f1
        0x180
        0x54e
        0x700
        0x7e0
        0x870
        0x906
        0x948
        0x7f5
        0xae0
        0xb13
        0xd02
        0xe2e
        0x678
        0x380
        0x900
        0xf9c
        0x1180
        0x120c
        0x14a0
        0xe15
        0x500
        0x34f
        0x378
        0x41d
        0x140
        0x457
        0x528
        0x5cc
        0x6f0
        0x882
        0x280
        0xa0e
        0xac8
        0x89d
        0xa50
        0xadd
        0x3c0
        0xef4
        0xea0
        0xb7c
        0xe60
        0x678
        0x190
        0x1b8
        0xcc0
        0xdcf
        0x1270
        0x2c3
        0x360
        0x3e7
        0x460
        0x457
        0x4b0
        0x1c0
        0x620
        0x882
        0x280
        0x39c
        0x3f0
        0x6ba
        0xb58
        0xa3b
        0xce4
        0xe2e
        0xa8c
        0xb7c
        0xda0
        0x72c
        0x7d0
        0x974
        0x7e0
        0x5be
    .end array-data

    :array_1
    .array-data 4
        0x24c
        0x340
        0x369
        0x44c
        0x499
        0x180
        0x69e
        0x6f0
        0x83a
        0x280
        0x8c4
        0xa68
        0x95a
        0x300
        0xc57
        0xd7a
        0xd89
        0xf78
        0xb44
        0x400
        0x1050
        0x1040
        0x120c
        0x1590
        0x460
        0xf28
        0x310
        0x380
        0x3cc
        0x41a
        0x441
        0x48c
        0x658
        0x690
        0x7ce
        0x898
        0x3c8
        0x300
        0x5fd
        0x300
        0xaf8
        0xd02
        0xe70
        0xe34
        0x380
        0xe80
        0xea0
        0x1068
        0x13c4
        0x600
        0xee7
        0xf28
        0x34f
        0x100
        0x3a8
        0x3f2
        0x4a4
        0x540
        0x1c0
        0x790
        0x7ce
        0x924
        0x2c0
        0xae0
        0x91b
        0x300
        0xc21
        0xd98
        0xf15
        0xe10
        0xd3c
        0x400
        0xda4
        0x1130
        0x1130
        0x600
        0xdcf
        0x12c0
        0x310
        0x360
        0x3e7
        0x474
        0x457
        0x228
        0x1c0
        0x490
        0x72c
        0x280
        0xa66
        0xa68
        0x999
        0x300
        0xc8d
        0xb5e
        0xe2e
        0x1050
        0x380
        0xe80
        0xf9c
        0x500
        0x141c
        0x1590
        0xdcf
        0x500
        0x32c
        0x340
        0x3b1
        0x47e
        0x160
        0x48c
        0x64a
        0x200
        0x72c
        0x7e4
        0x856
        0xae0
        0x999
        0xab0
        0xaa7
        0x3c0
        0xe4f
        0xe58
        0x380
        0xf20
        0xf9c
        0x1248
        0x1398
        0x600
        0xd43
        0x1180
        0x310
        0x160
        0x120
        0x42e
        0x483
        0x528
        0x578
        0x6c0
        0x882
        0x280
        0x856
        0xb10
        0x91b
        0x9d8
        0xa8c
        0x3c0
        0xcc3
        0xea0
        0xa9c
        0xdc0
        0xe7c
        0x1068
        0x12e8
        0x1350
        0x460
        0x1220
        0x2d8
        0x328
        0x120
        0x3de
        0x4e6
        0x4bc
        0x578
        0x690
        0x828
        0x8fc
        0x3c8
        0x300
        0x7f5
        0xac8
        0x360
        0xd5c
        0xd05
        0x102c
        0xc40
        0xca0
        0xdec
        0x1220
        0x580
        0x15c0
        0xf2d
        0x500
        0x32c
        0x340
        0x38d
        0x140
        0x44c
        0x4bc
        0x674
        0x650
        0x798
        0x8ac
        0x9a0
        0x978
        0x95a
        0x300
        0xbb5
        0xbf4
        0x420
        0x1050
        0xb60
        0xd20
        0x102c
        0x500
        0x10ac
        0x1500
        0xf50
        0x10e0
        0x2df
        0x318
        0x369
        0x488
        0x483
        0x534
        0x604
        0x2e0
    .end array-data
.end method


# virtual methods
.method public ai(Landroid/content/Context;)V
    .locals 13
    .annotation runtime Landroid/annotation/SuppressLint;
        value = "UnspecifiedRegisterReceiverFlag"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v12, -0x2

    const/4 v11, 0x0

    const/4 v10, 0x1

    const/4 v9, -0x1

    const/4 v8, 0x5

    .line 103
    const v0, 0x1030129

    invoke-virtual {p1, v0}, Landroid/content/Context;->setTheme(I)V

    .line 104
    const-string v0, "maincolor"

    const-string v1, "#8dc5b9"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->maincolor:Ljava/lang/String;

    .line 105
    const-string v0, "mainchatbox"

    const-string v1, "#57aaa0"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->mainchatbox:Ljava/lang/String;

    .line 106
    const-string v0, "selfchat"

    const-string v1, "#10000000"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchat:Ljava/lang/String;

    .line 107
    const-string v0, "selfchatc"

    const-string v1, "#253649"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->selfchatc:Ljava/lang/String;

    .line 108
    const-string v0, "aichat"

    const-string v1, "#25000000"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichat:Ljava/lang/String;

    .line 109
    const-string v0, "aichatc"

    const-string v1, "#ffffff"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->aichatc:Ljava/lang/String;

    .line 110
    const-string v0, "sendercolor"

    const-string v1, "#007500"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/AI;->fromcolor:Ljava/lang/String;

    .line 113
    const/4 v0, 0x0

    const/high16 v2, 0x41700000    # 15.0f

    .line 114
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "PREFERENCES"

    invoke-static {v1, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1, v11}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    .line 115
    new-instance v3, Landroid/graphics/drawable/ShapeDrawable;

    new-instance v4, Landroid/graphics/drawable/shapes/RoundRectShape;

    const/16 v1, 0x8

    new-array v5, v1, [F

    aput v0, v5, v11

    aput v0, v5, v10

    const/4 v1, 0x2

    aput v0, v5, v1

    const/4 v1, 0x3

    aput v0, v5, v1

    const/4 v1, 0x4

    aput v0, v5, v1

    aput v0, v5, v8

    const/4 v1, 0x6

    aput v0, v5, v1

    const/4 v1, 0x7

    aput v0, v5, v1

    const/4 v0, 0x0

    check-cast v0, Landroid/graphics/RectF;

    const/4 v1, 0x0

    check-cast v1, [F

    invoke-direct {v4, v5, v0, v1}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ShapeDrawable;-><init>(Landroid/graphics/drawable/shapes/Shape;)V

    .line 119
    new-instance v4, Landroid/graphics/drawable/ShapeDrawable;

    new-instance v5, Landroid/graphics/drawable/shapes/RoundRectShape;

    const/16 v0, 0x8

    new-array v6, v0, [F

    aput v2, v6, v11

    aput v2, v6, v10

    const/4 v0, 0x2

    aput v2, v6, v0

    const/4 v0, 0x3

    aput v2, v6, v0

    const/4 v0, 0x4

    aput v2, v6, v0

    aput v2, v6, v8

    const/4 v0, 0x6

    aput v2, v6, v0

    const/4 v0, 0x7

    aput v2, v6, v0

    const/4 v0, 0x0

    check-cast v0, Landroid/graphics/RectF;

    const/4 v1, 0x0

    check-cast v1, [F

    invoke-direct {v5, v6, v0, v1}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    invoke-direct {v4, v5}, Landroid/graphics/drawable/ShapeDrawable;-><init>(Landroid/graphics/drawable/shapes/Shape;)V

    .line 125
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    .line 126
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 127
    new-instance v1, Landroid/widget/EditText;

    invoke-direct {v1, p1}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    .line 128
    new-instance v1, Landroid/widget/ImageButton;

    invoke-direct {v1, p1}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    .line 129
    new-instance v1, Landroid/widget/ScrollView;

    invoke-direct {v1, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    .line 130
    new-instance v1, Landroid/widget/LinearLayout;

    invoke-direct {v1, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    .line 131
    new-instance v1, Landroid/view/View;

    invoke-direct {v1, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 132
    new-instance v2, Landroid/view/View;

    invoke-direct {v2, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 133
    new-instance v5, Landroid/speech/tts/TextToSpeech;

    invoke-direct {v5, p1, p0}, Landroid/speech/tts/TextToSpeech;-><init>(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;)V

    iput-object v5, p0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    .line 134
    invoke-static {p1}, Landroid/speech/SpeechRecognizer;->createSpeechRecognizer(Landroid/content/Context;)Landroid/speech/SpeechRecognizer;

    move-result-object v5

    iput-object v5, p0, Lmpop/revii/ai/AI;->sr:Landroid/speech/SpeechRecognizer;

    .line 137
    iget-object v5, p0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v7, 0x3f800000    # 1.0f

    invoke-direct {v6, v9, v12, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v5, v6}, Landroid/widget/ScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 138
    iget-object v5, p0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    const/16 v6, 0xa

    const/16 v7, 0xa

    invoke-virtual {v5, v8, v6, v8, v7}, Landroid/widget/ScrollView;->setPadding(IIII)V

    .line 140
    iget-object v5, p0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v6, v9, v12}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v6}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 141
    iget-object v5, p0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v10}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 142
    iget-object v5, p0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    const-string v6, "Welcome [Bot]"

    invoke-virtual {p0}, Lmpop/revii/ai/AI;->welcome()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, p1, v6, v7}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 145
    invoke-virtual {v3}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v5

    iget-object v6, p0, Lmpop/revii/ai/AI;->maincolor:Ljava/lang/String;

    invoke-static {v6}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 146
    invoke-virtual {v4}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v5

    iget-object v6, p0, Lmpop/revii/ai/AI;->mainchatbox:Ljava/lang/String;

    invoke-static {v6}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 149
    iget-object v5, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v3}, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 150
    iget-object v3, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v10}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 151
    iget-object v3, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    const/16 v5, 0xa

    const/16 v6, 0xa

    invoke-virtual {v3, v8, v5, v8, v6}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 152
    iget-object v3, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v11}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 153
    iget-object v3, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v5, v9, v9}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 155
    invoke-virtual {v0, v11}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 156
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v3, v9, v12}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 157
    const/16 v3, 0x50

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 158
    invoke-virtual {v0, v8, v8, v8, v8}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 160
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v6, 0x3f800000    # 1.0f

    invoke-direct {v5, v12, v9, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 161
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v5, "Post your question here"

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 162
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 163
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v3, v9}, Landroid/widget/EditText;->setTextColor(I)V

    .line 164
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const/16 v4, 0xff

    const/16 v5, 0xff

    const/16 v6, 0xff

    invoke-static {v4, v5, v6}, Lmpop/revii/ai/util;->rgbtohex(III)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setHintTextColor(I)V

    .line 165
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const/16 v4, 0x8

    const/16 v5, 0x8

    invoke-virtual {v3, v4, v8, v5, v8}, Landroid/widget/EditText;->setPadding(IIII)V

    .line 166
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setMaxLines(I)V

    .line 167
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v3, v10}, Landroid/widget/EditText;->setActivated(Z)V

    .line 168
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v3, v10}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 170
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    new-instance v4, Lmpop/revii/ai/AI$100000000;

    invoke-direct {v4, p0, p1}, Lmpop/revii/ai/AI$100000000;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 217
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    new-instance v4, Landroid/widget/RelativeLayout$LayoutParams;

    const/16 v5, 0x4b

    invoke-direct {v4, v12, v5}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 218
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v3, v11}, Landroid/widget/ImageButton;->setBackgroundColor(I)V

    .line 219
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 220
    const-string v3, "ic_send"

    const-string v4, "drawable"

    invoke-static {p1, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    .line 221
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    const v4, 0x1080050

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 232
    :goto_0
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    new-instance v4, Lmpop/revii/ai/AI$100000002;

    invoke-direct {v4, p0, p1}, Lmpop/revii/ai/AI$100000002;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 261
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    new-instance v4, Lmpop/revii/ai/AI$100000003;

    invoke-direct {v4, p0}, Lmpop/revii/ai/AI$100000003;-><init>(Lmpop/revii/ai/AI;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 294
    iget-object v3, p0, Lmpop/revii/ai/AI;->sr:Landroid/speech/SpeechRecognizer;

    new-instance v4, Lmpop/revii/ai/AI$100000005;

    invoke-direct {v4, p0, p1}, Lmpop/revii/ai/AI$100000005;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V

    invoke-virtual {v3, v4}, Landroid/speech/SpeechRecognizer;->setRecognitionListener(Landroid/speech/RecognitionListener;)V

    .line 357
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/16 v4, 0x19

    invoke-direct {v3, v4, v10}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 358
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v4, 0x2

    invoke-direct {v3, v9, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 359
    const-string v3, "#757575"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/view/View;->setBackgroundColor(I)V

    .line 361
    new-instance v3, Lmpop/revii/ai/AI$100000007;

    invoke-direct {v3, p0, p1}, Lmpop/revii/ai/AI$100000007;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V

    new-instance v4, Landroid/content/IntentFilter;

    iget-object v5, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "CONNECTION"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v3, v4}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 385
    iget-object v3, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    new-instance v4, Lmpop/revii/ai/AI$100000008;

    invoke-direct {v4, p0}, Lmpop/revii/ai/AI$100000008;-><init>(Lmpop/revii/ai/AI;)V

    new-instance v5, Landroid/content/IntentFilter;

    const-string v6, "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED"

    invoke-direct {v5, v6}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 395
    iget-object v3, p0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 396
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 397
    iget-object v1, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 398
    iget-object v1, p0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    iget-object v3, p0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 399
    iget-object v1, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 400
    iget-object v1, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 401
    iget-object v1, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 404
    iget-object v0, p0, Lmpop/revii/ai/AI;->base:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0}, Lmpop/revii/ai/AI;->addView(Landroid/view/View;)V

    return-void

    .line 223
    :cond_0
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    const-string v4, "ic_send"

    const-string v5, "drawable"

    invoke-static {p1, v4, v5}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto/16 :goto_0

    .line 226
    :cond_1
    const-string v3, "ic_microphone"

    const-string v4, "drawable"

    invoke-static {p1, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_2

    .line 227
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    const v4, 0x1080050

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto/16 :goto_0

    .line 229
    :cond_2
    iget-object v3, p0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    const-string v4, "ic_microphone"

    const-string v5, "drawable"

    invoke-static {p1, v4, v5}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto/16 :goto_0
.end method

.method public chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;
    .locals 10
    .annotation runtime Landroid/annotation/SuppressLint;
        value = "UnspecifiedRegisterReceiverFlag"
    .end annotation

    .prologue
    .line 423
    new-instance v3, Landroid/widget/LinearLayout;

    invoke-direct {v3, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 424
    new-instance v4, Lmpop/revii/ai/Markdown;

    invoke-direct {v4, p1}, Lmpop/revii/ai/Markdown;-><init>(Landroid/content/Context;)V

    .line 425
    new-instance v5, Landroid/widget/TextView;

    invoke-direct {v5, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 427
    const/16 v0, 0xa

    int-to-float v1, v0

    const/16 v0, -0x14

    int-to-float v2, v0

    .line 428
    iget-object v0, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v6, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v7, "USERNAME"

    invoke-static {v6, v7}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v7}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 430
    const/16 v0, -0x14

    int-to-float v0, v0

    move v2, v1

    .line 432
    :goto_0
    new-instance v6, Landroid/graphics/drawable/ShapeDrawable;

    new-instance v7, Landroid/graphics/drawable/shapes/RoundRectShape;

    const/16 v8, 0x8

    new-array v8, v8, [F

    const/4 v9, 0x0

    aput v1, v8, v9

    const/4 v9, 0x1

    aput v1, v8, v9

    const/4 v9, 0x2

    aput v1, v8, v9

    const/4 v9, 0x3

    aput v1, v8, v9

    const/4 v1, 0x4

    aput v0, v8, v1

    const/4 v1, 0x5

    aput v0, v8, v1

    const/4 v0, 0x6

    aput v2, v8, v0

    const/4 v0, 0x7

    aput v2, v8, v0

    const/4 v0, 0x0

    check-cast v0, Landroid/graphics/RectF;

    const/4 v1, 0x0

    check-cast v1, [F

    invoke-direct {v7, v8, v0, v1}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    invoke-direct {v6, v7}, Landroid/graphics/drawable/ShapeDrawable;-><init>(Landroid/graphics/drawable/shapes/Shape;)V

    .line 436
    iget-object v0, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "TEXTSIZE"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xa

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 438
    iget-object v1, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v7, "USERNAME"

    invoke-static {v2, v7}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-object v7, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v7}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v2, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 440
    const/4 v1, 0x5

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 441
    const/16 v1, 0x55

    const/4 v2, 0x5

    const/4 v7, 0x5

    const/4 v8, 0x5

    invoke-virtual {v3, v1, v2, v7, v8}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 442
    const/4 v1, 0x5

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 443
    iget-object v1, p0, Lmpop/revii/ai/AI;->selfchatc:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v4, v1}, Lmpop/revii/ai/Markdown;->setTextColor(I)V

    .line 444
    const/4 v1, 0x3

    invoke-virtual {v4, v1}, Lmpop/revii/ai/Markdown;->setGravity(I)V

    .line 445
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x2

    const/4 v7, -0x2

    invoke-direct {v1, v2, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v4, v1}, Lmpop/revii/ai/Markdown;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 446
    invoke-virtual {v6}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v1

    iget-object v2, p0, Lmpop/revii/ai/AI;->selfchat:Ljava/lang/String;

    invoke-static {v2}, Lmpop/revii/ai/util;->hextoargb(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 448
    invoke-virtual {v4, v6}, Lmpop/revii/ai/Markdown;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 449
    const-string v1, " :%s "

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p2, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 461
    :goto_1
    const/4 v1, 0x1

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 462
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v6, -0x2

    invoke-direct {v1, v2, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 463
    const/16 v1, 0xa

    const/16 v2, 0xa

    const/16 v6, 0xa

    const/16 v7, 0xa

    invoke-virtual {v5, v1, v2, v6, v7}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 464
    int-to-float v1, v0

    int-to-float v2, v0

    const/high16 v6, 0x40400000    # 3.0f

    div-float/2addr v2, v6

    sub-float/2addr v1, v2

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 465
    sget-object v1, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    const/4 v2, 0x3

    invoke-virtual {v5, v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 466
    iget-object v1, p0, Lmpop/revii/ai/AI;->fromcolor:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 467
    const/16 v1, 0xf

    const/16 v2, 0xa

    const/16 v6, 0xf

    const/16 v7, 0xa

    invoke-virtual {v4, v1, v2, v6, v7}, Lmpop/revii/ai/Markdown;->setPadding(IIII)V

    .line 468
    int-to-float v0, v0

    invoke-virtual {v4, v0}, Lmpop/revii/ai/Markdown;->setTextSize(F)V

    .line 469
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    invoke-virtual {v4, v0}, Lmpop/revii/ai/Markdown;->setTypeface(Landroid/graphics/Typeface;)V

    .line 470
    invoke-virtual {v4, p3}, Lmpop/revii/ai/Markdown;->setText(Ljava/lang/String;)V

    .line 473
    new-instance v0, Lmpop/revii/ai/AI$100000009;

    invoke-direct {v0, p0, v5, v4}, Lmpop/revii/ai/AI$100000009;-><init>(Lmpop/revii/ai/AI;Landroid/widget/TextView;Lmpop/revii/ai/Markdown;)V

    new-instance v1, Landroid/content/IntentFilter;

    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "TEXT_SIZE"

    invoke-static {v2, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 483
    iget-object v0, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "USERNAME"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v2}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 484
    iget-object v0, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "TEXT_TO_SPEECH"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "AI "

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 485
    invoke-virtual {v4}, Lmpop/revii/ai/Markdown;->getWithoutCode()Ljava/lang/String;

    move-result-object v0

    .line 486
    invoke-virtual {p0, v0}, Lmpop/revii/ai/AI;->speak(Ljava/lang/String;)V

    .line 491
    :cond_0
    new-instance v0, Lmpop/revii/ai/AI$100000011;

    invoke-direct {v0, p0, p1, v4}, Lmpop/revii/ai/AI$100000011;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;Lmpop/revii/ai/Markdown;)V

    invoke-virtual {v4, v0}, Lmpop/revii/ai/Markdown;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 519
    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 520
    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 521
    return-object v3

    .line 452
    :cond_1
    const/4 v1, 0x5

    const/4 v2, 0x5

    const/16 v7, 0x55

    const/4 v8, 0x5

    invoke-virtual {v3, v1, v2, v7, v8}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 453
    const/4 v1, 0x3

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 454
    invoke-virtual {v6}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v1

    iget-object v2, p0, Lmpop/revii/ai/AI;->aichat:Ljava/lang/String;

    invoke-static {v2}, Lmpop/revii/ai/util;->hextoargb(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 455
    iget-object v1, p0, Lmpop/revii/ai/AI;->aichatc:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v4, v1}, Lmpop/revii/ai/Markdown;->setTextColor(I)V

    .line 456
    invoke-virtual {v4, v6}, Lmpop/revii/ai/Markdown;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 457
    const-string v1, " %s: "

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p2, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    :cond_2
    move v0, v1

    goto/16 :goto_0
.end method

.method feedback()V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 658
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 659
    new-instance v1, Lmpop/revii/ai/AI$100000013;

    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v1, p0, v2}, Lmpop/revii/ai/AI$100000013;-><init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V

    .line 666
    const-string v2, "Facebook feedback"

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 668
    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    .line 669
    invoke-virtual {v2, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 670
    invoke-virtual {v2, v4}, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V

    .line 671
    invoke-virtual {v2, v4}, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V

    .line 672
    invoke-virtual {v2, v4}, Landroid/webkit/WebSettings;->setAllowFileAccessFromFileURLs(Z)V

    .line 673
    invoke-virtual {v2, v4}, Landroid/webkit/WebSettings;->setAppCacheEnabled(Z)V

    .line 674
    const/16 v3, 0xc8

    new-array v3, v3, [I

    fill-array-data v3, :array_0

    invoke-static {v3}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 676
    invoke-virtual {v1}, Landroid/webkit/WebView;->requestFocus()Z

    .line 677
    invoke-virtual {v1, v4}, Landroid/webkit/WebView;->setFocusable(Z)V

    .line 678
    invoke-virtual {v1, v4}, Landroid/webkit/WebView;->setFocusableInTouchMode(Z)V

    .line 679
    new-instance v2, Landroid/webkit/WebViewClient;

    invoke-direct {v2}, Landroid/webkit/WebViewClient;-><init>()V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 686
    new-instance v2, Lmpop/revii/ai/AI$100000014;

    invoke-direct {v2, p0}, Lmpop/revii/ai/AI$100000014;-><init>(Lmpop/revii/ai/AI;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 728
    const/16 v2, 0x3a

    new-array v2, v2, [I

    fill-array-data v2, :array_1

    invoke-static {v2}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 730
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 731
    const-string v1, "Close"

    new-instance v2, Lmpop/revii/ai/AI$100000015;

    invoke-direct {v2, p0}, Lmpop/revii/ai/AI$100000015;-><init>(Lmpop/revii/ai/AI;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 738
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 739
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void

    .line 674
    nop

    :array_0
    .array-data 4
        0x21b
        0x378
        0x44a
        0x41a
        0x4a4
        0x510
        0x54e
        0x2f0
        0x3ba
        0x398
        0x420
        0x300
        0x348
        0x720
        0xb13
        0xce4
        0xf15
        0x10e0
        0x674
        0x400
        0x924
        0x1130
        0x1130
        0x1560
        0xf2d
        0x1068
        0x2bc
        0x100
        0x1b9
        0x1fe
        0x289
        0x180
        0x48a
        0x4c0
        0x372
        0x3d4
        0x44c
        0x648
        0x2a0
        0x630
        0xc57
        0xc4e
        0xdec
        0xe10
        0x524
        0xa80
        0xb40
        0x7a8
        0xb2c
        0x8a0
        0x6d6
        0x7d0
        0x150
        0x1b0
        0x1c2
        0x208
        0x1fa
        0x240
        0x2ae
        0x340
        0x426
        0x280
        0xa3a
        0xb10
        0x35d
        0x300
        0x6db
        0xd20
        0xe70
        0xf30
        0xb0c
        0xae0
        0xe34
        0xf50
        0xce4
        0x13b0
        0xfdc
        0x758
        0x173
        0x198
        0x1ef
        0x1cc
        0x231
        0x288
        0x1c0
        0x280
        0x546
        0x5a0
        0x738
        0x738
        0x63c
        0x420
        0x360
        0xca8
        0xd89
        0xf0c
        0xb0c
        0x400
        0x9fc
        0xfc8
        0x1104
        0x1410
        0xf2d
        0x668
        0xe0
        0x2b0
        0x38d
        0x474
        0x4f1
        0x4ec
        0x612
        0x6e0
        0x34e
        0x410
        0x3f4
        0x480
        0x2a0
        0x648
        0xaf8
        0xd5c
        0xe4f
        0xf54
        0xb0c
        0x5e0
        0x6e4
        0x7d0
        0x8c4
        0x8a0
        0x690
        0x730
        0x17a
        0x198
        0x1b9
        0x1f4
        0x1fa
        0x270
        0x2a0
        0x200
        0x56a
        0x8ac
        0x86c
        0x9d8
        0x8dc
        0x978
        0x360
        0x9ba
        0xc81
        0xe58
        0xa9c
        0xe40
        0xec4
        0x758
        0x91c
        0x990
        0x785
        0x730
        0x165
        0x1b0
        0x333
        0x2bc
        0x2d6
        0x30c
        0x444
        0x2f0
        0x4da
        0x604
        0x596
        0x588
        0x5be
        0x630
        0x804
        0x7da
        0x60f
        0xe34
        0xc08
        0xbe0
        0xbf4
        0xcf8
        0xa24
        0xd20
        0x906
        0xa28
        0x25a
        0x178
        0x1cb
        0x23a
        0x268
        0x228
        0x2a0
        0x2e0
        0x360
        0x398
        0x436
        0x4c8
        0x3c6
        0x498
        0x52b
        0x5fa
        0x79b
        0xd14
    .end array-data

    .line 728
    :array_1
    .array-data 4
        0x2d8
        0x3a0
        0x414
        0x460
        0x4f1
        0x2b8
        0x292
        0x2f0
        0x72c
        0x8e8
        0x8ae
        0x978
        0x3c6
        0x990
        0xa3b
        0xb9a
        0xd05
        0xdc8
        0xc24
        0xde0
        0xf0c
        0x730
        0x1104
        0x14d0
        0xee7
        0x758
        0x2fb
        0x328
        0x40b
        0x47e
        0x42b
        0x4d4
        0x586
        0x730
        0x34e
        0x910
        0x8f0
        0xab0
        0x849
        0x918
        0xa8c
        0x582
        0x651
        0x6c0
        0x55c
        0x680
        0x7e0
        0x820
        0x8c4
        0xa50
        0x73f
        0x820
        0x150
        0x1c8
        0x1cb
        0x23a
        0x226
        0x234
    .end array-data
.end method

.method public onInit(I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 409
    if-nez p1, :cond_1

    .line 410
    iget-object v0, p0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Landroid/speech/tts/TextToSpeech;->setLanguage(Ljava/util/Locale;)I

    move-result v0

    .line 411
    iget-object v1, p0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    const v2, 0x3f99999a    # 1.2f

    invoke-virtual {v1, v2}, Landroid/speech/tts/TextToSpeech;->setSpeechRate(F)I

    .line 412
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 413
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v1, "Please check your text to speech data on settings."

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 416
    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v1, "Failed to Initiate"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method

.method preferences()V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 617
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 618
    new-instance v0, Landroid/widget/LinearLayout;

    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v0, v2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 620
    new-instance v2, Landroid/widget/EditText;

    iget-object v3, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 621
    new-instance v3, Landroid/widget/EditText;

    iget-object v4, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v3, v4}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 623
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 625
    invoke-virtual {v2}, Landroid/widget/EditText;->setSingleLine()V

    .line 626
    const-string v4, "Enter your prefered name"

    invoke-virtual {v2, v4}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 627
    iget-object v4, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "USERNAME"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v6}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 629
    invoke-virtual {v3}, Landroid/widget/EditText;->setSingleLine()V

    .line 630
    const-string v4, "Enter your prefered text size"

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 631
    iget-object v4, p0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "TEXTSIZE"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const/16 v6, 0xa

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 632
    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setInputType(I)V

    .line 634
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 635
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 637
    const-string v4, "Preferences"

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 638
    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 639
    const-string v0, "Confirm"

    new-instance v4, Lmpop/revii/ai/AI$100000012;

    invoke-direct {v4, p0, v2, v3}, Lmpop/revii/ai/AI$100000012;-><init>(Lmpop/revii/ai/AI;Landroid/widget/EditText;Landroid/widget/EditText;)V

    invoke-virtual {v1, v0, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 651
    const-string v2, "Close"

    const/4 v0, 0x0

    check-cast v0, Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {v1, v2, v0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 652
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 653
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method speak()V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 525
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_1

    .line 526
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v1, "android.permission.RECORD_AUDIO"

    invoke-virtual {v0, v1}, Landroid/content/Context;->checkSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_0

    .line 527
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.speech.action.RECOGNIZE_SPEECH"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 528
    const-string v1, "android.speech.extra.LANGUAGE"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 529
    const-string v1, "android.speech.extra.LANGUAGE_MODEL"

    const-string v2, "free_form"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 530
    const-string v1, "android.speech.extra.PROMPT"

    const-string v2, "Say something"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 532
    :try_start_0
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "Listening"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 533
    iget-object v1, p0, Lmpop/revii/ai/AI;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v1, v0}, Landroid/speech/SpeechRecognizer;->startListening(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 549
    :goto_0
    return-void

    .line 533
    :catch_0
    move-exception v0

    .line 535
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Error: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 538
    :cond_0
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v1, "Please enable audio permission"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 541
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.speech.action.RECOGNIZE_SPEECH"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 542
    const-string v1, "android.speech.extra.LANGUAGE"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 543
    const-string v1, "android.speech.extra.LANGUAGE_MODEL"

    const-string v2, "free_form"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 544
    const-string v1, "android.speech.extra.PROMPT"

    const-string v2, "Say something"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 546
    :try_start_1
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "Listening"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 547
    iget-object v1, p0, Lmpop/revii/ai/AI;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v1, v0}, Landroid/speech/SpeechRecognizer;->startListening(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    .line 549
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Error: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method

.method speak(Ljava/lang/String;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 556
    const-string v4, ""

    .line 557
    const-string v0, "\n"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    move v5, v3

    .line 558
    :goto_0
    array-length v0, v6

    if-lt v5, v0, :cond_0

    .line 578
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v0, v2, :cond_2

    .line 579
    iget-object v2, p0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    move-object v0, v1

    check-cast v0, Landroid/os/Bundle;

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v4, v3, v0, v1}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/CharSequence;ILandroid/os/Bundle;Ljava/lang/String;)I

    .line 581
    :goto_1
    return-void

    .line 559
    :cond_0
    aget-object v0, v6, v5

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    move v2, v3

    move-object v0, v4

    .line 560
    :goto_2
    array-length v4, v7

    if-lt v2, v4, :cond_1

    .line 558
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    move-object v4, v0

    goto :goto_0

    .line 562
    :cond_1
    :try_start_0
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    aget-object v9, v7, v2

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 560
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 562
    :catch_0
    move-exception v4

    .line 564
    const-string v4, "0"

    const-string v8, "zero"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 565
    const-string v4, "1"

    const-string v8, "one"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 566
    const-string v4, "2"

    const-string v8, "two"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 567
    const-string v4, "3"

    const-string v8, "three"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 568
    const-string v4, "4"

    const-string v8, "four"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 569
    const-string v4, "5"

    const-string v8, "five"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 570
    const-string v4, "6"

    const-string v8, "six"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 571
    const-string v4, "7"

    const-string v8, "seven"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 572
    const-string v4, "8"

    const-string v8, "eight"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 573
    const-string v4, "9"

    const-string v8, "nine"

    invoke-virtual {v0, v4, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 574
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v8, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v8, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v8, " "

    invoke-virtual {v4, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    .line 581
    :cond_2
    iget-object v0, p0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v0, v4, v3, v1}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_1
.end method

.method welcome()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v1, 0x0

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    move-object v0, v1

    .line 587
    check-cast v0, Landroid/content/pm/PackageInfo;

    .line 588
    check-cast v1, Landroid/content/pm/ApplicationInfo;

    .line 590
    :try_start_0
    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 591
    iget-object v2, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    move-object v2, v0

    .line 596
    :goto_0
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "modder"

    const-string v4, "string"

    invoke-static {v0, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 597
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v4, "message"

    const-string v5, "string"

    invoke-static {v0, v4, v5}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 599
    iget-object v0, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 600
    if-nez v3, :cond_0

    const-string v1, "Developed by %s"

    new-array v3, v8, [Ljava/lang/Object;

    sget-object v5, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v5}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v7

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    move-object v3, v1

    .line 601
    :goto_1
    if-nez v4, :cond_1

    iget-object v1, p0, Lmpop/revii/ai/AI;->msg_:[I

    invoke-static {v1}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v1

    .line 602
    :goto_2
    const-string v4, "* v3 -> (GPT-4)\n* v3-32k -> (GPT-4 32k)\n* turbo -> (GPT 3.5 Turbo)\n* turbo-16k -> (GPT 3.5 Turbo 16k)\n* gemini -> (Google Gemini Pro) [Unstable]"

    .line 603
    const-string v5, ""

    if-ne v0, v5, :cond_2

    .line 604
    const-string v0, "Ai Haibara"

    .line 608
    :goto_3
    const-string v5, "%s - [\u1d20. %s]"

    new-array v6, v9, [Ljava/lang/Object;

    aput-object v0, v6, v7

    iget-object v0, v2, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    aput-object v0, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 609
    const-string v0, ""

    if-ne v1, v0, :cond_3

    .line 610
    const-string v0, "> Thank you for using this application, I hope this may help you to study and explore. If you want to use this as feature of your app, kindly avoid changing the credits, as respect to the developer of this application."

    .line 614
    :goto_4
    iget-object v1, p0, Lmpop/revii/ai/AI;->welcome:[I

    invoke-static {v1}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v1

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v2, v5, v7

    aput-object v3, v5, v8

    aput-object v0, v5, v9

    const/4 v0, 0x3

    aput-object v4, v5, v0

    invoke-static {v1, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 591
    :catch_0
    move-exception v2

    .line 593
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    move-object v2, v0

    goto :goto_0

    .line 600
    :cond_0
    const-string v1, "Modified by: %s"

    new-array v5, v8, [Ljava/lang/Object;

    iget-object v6, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v7

    invoke-static {v1, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    move-object v3, v1

    goto :goto_1

    .line 601
    :cond_1
    iget-object v1, p0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 606
    :cond_2
    const-string v5, "%s"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object v0, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    .line 612
    :cond_3
    const-string v0, "> %s"

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v7

    invoke-static {v0, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_4
.end method
