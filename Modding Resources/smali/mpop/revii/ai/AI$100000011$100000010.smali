.class Lmpop/revii/ai/AI$100000011$100000010;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI$100000011;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000010"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI$100000011;

.field private final val$ctx:Landroid/content/Context;

.field private final val$list:Lmpop/revii/ai/Adapter;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI$100000011;Landroid/content/Context;Lmpop/revii/ai/Adapter;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000011$100000010;->this$0:Lmpop/revii/ai/AI$100000011;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000011$100000010;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lmpop/revii/ai/AI$100000011$100000010;->val$list:Lmpop/revii/ai/Adapter;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000011$100000010;)Lmpop/revii/ai/AI$100000011;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000011$100000010;->this$0:Lmpop/revii/ai/AI$100000011;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/DialogInterface;",
            "I)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 502
    iget-object v0, p0, Lmpop/revii/ai/AI$100000011$100000010;->val$ctx:Landroid/content/Context;

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    iget-object v1, p0, Lmpop/revii/ai/AI$100000011$100000010;->val$list:Lmpop/revii/ai/Adapter;

    invoke-virtual {v1, p2}, Lmpop/revii/ai/Adapter;->fetchItem(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 503
    iget-object v0, p0, Lmpop/revii/ai/AI$100000011$100000010;->val$ctx:Landroid/content/Context;

    const-string v1, "Text Copied"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    return-void
.end method
