.class Lmpop/revii/ai/AI$100000014;
.super Landroid/webkit/WebChromeClient;
.source "AI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000014"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;)V
    .locals 0

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000014;->this$0:Lmpop/revii/ai/AI;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000014;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000014;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public openFileChooser(Landroid/webkit/ValueCallback;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 688
    iget-object v0, p0, Lmpop/revii/ai/AI$100000014;->this$0:Lmpop/revii/ai/AI;

    iput-object p1, v0, Lmpop/revii/ai/AI;->vuri:Landroid/webkit/ValueCallback;

    .line 689
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 690
    const-string v1, "android.intent.category.OPENABLE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 691
    const-string v1, "*/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    return-void
.end method

.method public openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 696
    iget-object v0, p0, Lmpop/revii/ai/AI$100000014;->this$0:Lmpop/revii/ai/AI;

    iput-object p1, v0, Lmpop/revii/ai/AI;->vuri:Landroid/webkit/ValueCallback;

    .line 697
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 698
    const-string v1, "android.intent.category.OPENABLE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 699
    const-string v1, "*/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    return-void
.end method

.method public openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 704
    iget-object v0, p0, Lmpop/revii/ai/AI$100000014;->this$0:Lmpop/revii/ai/AI;

    iput-object p1, v0, Lmpop/revii/ai/AI;->vuri:Landroid/webkit/ValueCallback;

    .line 705
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 706
    const-string v1, "android.intent.category.OPENABLE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 707
    const-string v1, "*/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    return-void
.end method
