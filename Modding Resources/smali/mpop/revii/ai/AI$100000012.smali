.class Lmpop/revii/ai/AI$100000012;
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
    name = "100000012"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$name:Landroid/widget/EditText;

.field private final val$size:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/widget/EditText;Landroid/widget/EditText;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000012;->val$name:Landroid/widget/EditText;

    iput-object p3, p0, Lmpop/revii/ai/AI$100000012;->val$size:Landroid/widget/EditText;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000012;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 10
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
    .line 642
    iget-object v0, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v1, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v2, "USERNAME"

    invoke-static {v1, v2}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->val$name:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 643
    iget-object v0, p0, Lmpop/revii/ai/AI$100000012;->val$size:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "TEXTSIZE"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0xa

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->validator(Ljava/lang/String;I)I

    move-result v0

    .line 644
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "TEXT_SIZE"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 645
    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "TEXTSIZE"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 646
    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    iget-object v3, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v4, "TEXTSIZE"

    invoke-static {v3, v4}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 647
    iget-object v2, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v5, "Preferences"

    const-string v6, "Preference changed:\nName: `%s`\nText size: `%d`"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lmpop/revii/ai/AI$100000012;->val$name:Landroid/widget/EditText;

    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-interface {v9}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    new-instance v9, Ljava/lang/Integer;

    invoke-direct {v9, v0}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v4, v5, v0}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 648
    iget-object v0, p0, Lmpop/revii/ai/AI$100000012;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    return-void
.end method
