.class public Lmpop/revii/ai/connection;
.super Landroid/os/AsyncTask;
.source "connection.java"


# instance fields
.field ctx:Landroid/content/Context;

.field name:Ljava/lang/String;

.field query:[I

.field relationship:Ljava/lang/String;

.field sp:Landroid/content/SharedPreferences;

.field url:Ljava/lang/String;

.field userID:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/connection;->url:Ljava/lang/String;

    const/16 v0, 0x5b

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lmpop/revii/ai/connection;->query:[I

    const-string v0, "girlfriend"

    iput-object v0, p0, Lmpop/revii/ai/connection;->relationship:Ljava/lang/String;

    const-string v0, "Ai Haibara"

    iput-object v0, p0, Lmpop/revii/ai/connection;->name:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    .line 27
    iput-object p1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    .line 28
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "PREFERENCES"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/connection;->sp:Landroid/content/SharedPreferences;

    return-void

    .line 26
    :array_0
    .array-data 4
        0x230
        0x390
        0x38d
        0x488
        0x457
        0x528
        0x578
        0x200
        0x828
        0x820
        0x856
        0xae0
        0x2a0
        0xb58
        0xbb5
        0xdb6
        0xeb2
        0x480
        0xc08
        0xc20
        0xf54
        0xfc8
        0x580
        0x13b0
        0xfb9
        0x500
        0x103
        0x398
        0x18c
        0x140
        0x197
        0x564
        0x1c0
        0x6f0
        0x72c
        0x280
        0x32e
        0xac8
        0x3c6
        0x300
        0x83a
        0xd02
        0xf57
        0x630
        0x380
        0xda0
        0x1104
        0x500
        0x12e8
        0x1230
        0xee7
        0xfc8
        0xe0
        0x348
        0x40b
        0x140
        0x197
        0x564
        0x284
        0x200
        0x57c
        0x8ac
        0xa3a
        0x300
        0x888
        0x978
        0xc06
        0xbd6
        0x507
        0x102c
        0x380
        0xda0
        0x1104
        0x500
        0x12e8
        0x12f0
        0x1068
        0x1220
        0xe0
        0x390
        0x38d
        0x47e
        0x4d0
        0x534
        0x604
        0x730
        0x71a
        0x488
        0x2c0
        0x378
        0x96f
    .end array-data
.end method


# virtual methods
.method protected bridge doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, [Ljava/lang/Object;

    invoke-virtual {p0, p1}, Lmpop/revii/ai/connection;->doInBackground([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected doInBackground([Ljava/lang/Object;)Ljava/lang/String;
    .locals 6
    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 35
    const/4 v0, 0x0

    :try_start_0
    aget-object v0, p1, v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 36
    iget-object v1, p0, Lmpop/revii/ai/connection;->sp:Landroid/content/SharedPreferences;

    iget-object v2, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v3, "USER_ID"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    .line 38
    iget-object v1, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 40
    iget-object v1, p0, Lmpop/revii/ai/connection;->query:[I

    invoke-static {v1}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lmpop/revii/ai/connection;->name:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lmpop/revii/ai/connection;->relationship:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x2

    sget-object v4, Lmpop/revii/ai/AI;->developer:[I

    invoke-static {v4}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const/4 v4, 0x1

    aget-object v4, p1, v4

    aput-object v4, v2, v3

    const/4 v3, 0x4

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 46
    :goto_0
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const/16 v2, 0x33

    new-array v2, v2, [I

    fill-array-data v2, :array_0

    invoke-static {v2}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "UTF-8"

    invoke-static {v0, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-object v1, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/connection;->url:Ljava/lang/String;

    .line 49
    new-instance v0, Ljava/net/URL;

    iget-object v1, p0, Lmpop/revii/ai/connection;->url:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 50
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v1

    .line 51
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Ljava/net/URLConnection;->setDoInput(Z)V

    .line 52
    const-string v0, ""

    .line 54
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-virtual {v1}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 55
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 59
    :goto_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 63
    :goto_2
    return-object v0

    .line 42
    :cond_0
    iget-object v1, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    .line 43
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "&user="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "UTF-8"

    invoke-static {v1, v3}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 61
    :catch_0
    move-exception v0

    .line 63
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "{\"response\": \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 56
    :cond_1
    :try_start_1
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto :goto_1

    .line 46
    nop

    :array_0
    .array-data 4
        0x2d8
        0x3a0
        0x414
        0x460
        0x4f1
        0x2b8
        0x292
        0x2f0
        0x7e0
        0x8ac
        0x948
        0xa20
        0x89d
        0xa50
        0xa3b
        0xd98
        0xd89
        0xf9c
        0xc08
        0xe60
        0x654
        0xf28
        0x120c
        0x870
        0xfb9
        0x1068
        0x2d1
        0x368
        0x369
        0x1cc
        0x512
        0x4bc
        0x63c
        0x630
        0x71a
        0x870
        0x3f4
        0x918
        0x930
        0xa80
        0x6a5
        0xcc6
        0xd05
        0x102c
        0xc94
        0xc20
        0xe7c
        0xfc8
        0xa7c
        0x6f0
        0xfb9
    .end array-data
.end method

.method protected onPostExecute(Ljava/lang/Object;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const/4 v8, 0x1

    .line 74
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 76
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 78
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v3, "CONNECTION"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 79
    const-string v2, "response"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lmpop/revii/ai/connection;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 80
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_DATA"

    invoke-static {v0, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "Something went wrong"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 81
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_RETURN"

    invoke-static {v0, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 82
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_SENDER"

    invoke-static {v0, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "AI [%s]"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lmpop/revii/ai/connection;->sp:Landroid/content/SharedPreferences;

    iget-object v6, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v7, "AI_ALIAS"

    invoke-static {v6, v7}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "AI"

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 92
    :goto_0
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 98
    :goto_1
    return-void

    .line 84
    :cond_0
    iget-object v2, p0, Lmpop/revii/ai/connection;->userID:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-gtz v2, :cond_1

    .line 85
    iget-object v2, p0, Lmpop/revii/ai/connection;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    iget-object v3, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v4, "USER_ID"

    invoke-static {v3, v4}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "user"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 87
    :cond_1
    const-string v2, "url"

    iget-object v3, p0, Lmpop/revii/ai/connection;->url:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 88
    iget-object v2, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v3, "CONNECTION_DATA"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "response"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 89
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_RETURN"

    invoke-static {v0, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 90
    iget-object v0, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_SENDER"

    invoke-static {v0, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "AI [%s]"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lmpop/revii/ai/connection;->sp:Landroid/content/SharedPreferences;

    iget-object v6, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v7, "AI_ALIAS"

    invoke-static {v6, v7}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "AI"

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 92
    :catch_0
    move-exception v0

    .line 94
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 95
    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_DATA"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 96
    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_RETURN"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 97
    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    const-string v2, "CONNECTION_SENDER"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Error [Bot]"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 98
    iget-object v1, p0, Lmpop/revii/ai/connection;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_1
.end method

.method protected onPreExecute()V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 69
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    return-void
.end method
