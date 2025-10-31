.class Lmpop/revii/ai/AI$100000015;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000015"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000015;->this$0:Lmpop/revii/ai/AI;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000015;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000015;->this$0:Lmpop/revii/ai/AI;

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
    const/4 v1, 0x1

    .line 734
    iget-object v0, p0, Lmpop/revii/ai/AI$100000015;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setActivated(Z)V

    .line 735
    iget-object v0, p0, Lmpop/revii/ai/AI$100000015;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setEnabled(Z)V

    return-void
.end method
