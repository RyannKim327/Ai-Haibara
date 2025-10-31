.class Lmpop/revii/ai/AI$100000011;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000011"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmpop/revii/ai/AI$100000011$100000010;
    }
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$chat:Lmpop/revii/ai/Markdown;

.field private final val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;Lmpop/revii/ai/Markdown;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000011;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000011;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lmpop/revii/ai/AI$100000011;->val$chat:Lmpop/revii/ai/Markdown;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000011;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000011;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 5
    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 495
    :try_start_0
    new-instance v0, Lmpop/revii/ai/Adapter;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000011;->val$ctx:Landroid/content/Context;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000011;->val$chat:Lmpop/revii/ai/Markdown;

    invoke-virtual {v3}, Lmpop/revii/ai/Markdown;->getLanguage()Ljava/util/ArrayList;

    move-result-object v3

    iget-object v4, p0, Lmpop/revii/ai/AI$100000011;->val$chat:Lmpop/revii/ai/Markdown;

    invoke-virtual {v4}, Lmpop/revii/ai/Markdown;->getAllCodes()Ljava/util/ArrayList;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Lmpop/revii/ai/Adapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 496
    new-instance v2, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000011;->val$ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 497
    const-string v3, "Codes from this message"

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 498
    iget-object v3, p0, Lmpop/revii/ai/AI$100000011;->val$chat:Lmpop/revii/ai/Markdown;

    invoke-virtual {v3}, Lmpop/revii/ai/Markdown;->getAllCodes()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 499
    new-instance v3, Lmpop/revii/ai/AI$100000011$100000010;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000011;->val$ctx:Landroid/content/Context;

    invoke-direct {v3, p0, v4, v0}, Lmpop/revii/ai/AI$100000011$100000010;-><init>(Lmpop/revii/ai/AI$100000011;Landroid/content/Context;Lmpop/revii/ai/Adapter;)V

    invoke-virtual {v2, v0, v3}, Landroid/app/AlertDialog$Builder;->setAdapter(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 509
    :goto_0
    const-string v3, "Close"

    const/4 v0, 0x0

    check-cast v0, Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {v2, v3, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 510
    iget-object v0, p0, Lmpop/revii/ai/AI$100000011;->val$chat:Lmpop/revii/ai/Markdown;

    invoke-virtual {v0}, Lmpop/revii/ai/Markdown;->getAllCodes()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {v2, v0}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 511
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 515
    :goto_2
    return v1

    .line 507
    :cond_0
    const-string v0, "There is no codes here."

    invoke-virtual {v2, v0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 511
    :catch_0
    move-exception v0

    .line 513
    iget-object v2, p0, Lmpop/revii/ai/AI$100000011;->val$ctx:Landroid/content/Context;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_2

    :cond_1
    move v0, v1

    .line 510
    goto :goto_1
.end method
