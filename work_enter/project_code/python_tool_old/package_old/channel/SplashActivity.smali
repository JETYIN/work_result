.class public Lcom/haowan/funcell/sdk/api/splash/SplashActivity;
.super Landroid/app/Activity;
.source "SplashActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/haowan/funcell/sdk/api/splash/SplashActivity;)V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->startGameActivity()V

    return-void
.end method

.method private appendAnimation()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 29
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/4 v4, 0x0

    const/high16 v5, 0x3f800000

    invoke-direct {v0, v4, v5}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 30
    .local v0, "ani":Landroid/view/animation/AlphaAnimation;
    const/4 v4, 0x2

    invoke-virtual {v0, v4}, Landroid/view/animation/AlphaAnimation;->setRepeatMode(I)V

    .line 31
    invoke-virtual {v0, v8}, Landroid/view/animation/AlphaAnimation;->setRepeatCount(I)V

    .line 32
    const-wide/16 v4, 0x7d0

    invoke-virtual {v0, v4, v5}, Landroid/view/animation/AlphaAnimation;->setDuration(J)V

    .line 33
    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const-string v5, "fun_plugin_splash_img"

    const-string v6, "id"

    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v5, v6, v7}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    invoke-virtual {p0, v4}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 35
    .local v2, "image":Landroid/widget/ImageView;
    if-nez v2, :cond_0

    .line 36
    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const-string v5, "fun_plugin_splash_layout"

    const-string v6, "id"

    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v5, v6, v7}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 37
    .local v1, "defaultID":I
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v1, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 38
    .local v3, "layout":Landroid/widget/RelativeLayout;
    invoke-virtual {v3, v8}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .end local v2    # "image":Landroid/widget/ImageView;
    check-cast v2, Landroid/widget/ImageView;

    .line 44
    .end local v1    # "defaultID":I
    .end local v3    # "layout":Landroid/widget/RelativeLayout;
    .restart local v2    # "image":Landroid/widget/ImageView;
    :cond_0
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setAnimation(Landroid/view/animation/Animation;)V

    .line 45
    new-instance v4, Lcom/haowan/funcell/sdk/api/splash/SplashActivity$1;

    invoke-direct {v4, p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity$1;-><init>(Lcom/haowan/funcell/sdk/api/splash/SplashActivity;)V

    invoke-virtual {v0, v4}, Landroid/view/animation/AlphaAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 64
    return-void
.end method

.method private startGameActivity()V
    .locals 4

    .prologue
    .line 68
    :try_start_0
    const-string v3, "###FuncellSdk_Start_Activity###"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 69
    .local v2, "mainClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 70
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 71
    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "mainClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    return-void

    .line 73
    :catch_0
    move-exception v0

    .line 74
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 22
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 23
    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "funcell_plugin_splash"

    const-string v3, "layout"

    invoke-virtual {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 24
    .local v0, "layoutID":I
    invoke-virtual {p0, v0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->setContentView(I)V

    .line 25
    invoke-direct {p0}, Lcom/haowan/funcell/sdk/api/splash/SplashActivity;->appendAnimation()V

    .line 26
    return-void
.end method
