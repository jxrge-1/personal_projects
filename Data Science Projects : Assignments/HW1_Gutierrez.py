import pandas as pd
from matplotlib import pyplot as plt
import seaborn as sns
from sklearn.decomposition import PCA
from sklearn.manifold import TSNE

# reading the file from our path into a variable called data
data = pd.read_csv('/Users/jorgegutierrezjr./Downloads/lncRNA_5_Cancers (1).csv')

# We have our own separate individual Cancer Class column
cancer_Class = data['Class']
cancer_Class_2 = data['Class']
# print(cancer_Class)

# We are dropping the TEXT-ONLY columns with the code below,
# so it will not crash when my scale the data
data = data.drop('Class', axis=1)
data = data.drop('Ensembl_ID', axis=1)

# Scaling the data --> NOT NEEDED TO SCALE IN THIS ASSIGNMENT
# scaler = StandardScaler()
# scaled_data = scaler.fit_transform(data)

# Performing PCA to have two components
pca = PCA(n_components=2)
pc_data = pca.fit_transform(data)

# A DF to show the new standardized data
pc_df = pd.DataFrame(data=pc_data, columns=['PC1', 'PC2'])

# adding the Class column to the
pc_df['Class'] = cancer_Class

# plotting the points
plt.figure(figsize=(10, 8))
cancer_Class = pc_df['Class'].unique()
colors = ['b', 'y', 'g', 'c', 'm']

# we are iterating over the values in colors
for i, cancer_Class in enumerate(cancer_Class):
    subset = pc_df[pc_df['Class'] == cancer_Class]
    plt.scatter(subset['PC1'], subset['PC2'], c=colors[i], label=cancer_Class)

plt.xlabel('PC1')
plt.ylabel('PC2')
plt.title('Figure No.1: PCA of lncRNA')
plt.legend()
plt.grid()
plt.show()

# BELOW IS THE WORK FOR NO.2 PLOTTING VIOLIN PLOTS
# This is our subplots map for PC1/2
# 1, 2 signify 1 Row and 2 Columns
fig, axes = plt.subplots(1, 2, figsize=(12, 8))

# BELOW ARE THE VIOLIN PLOT CODE
# # Labeling our graphs for readability
sns.violinplot(x='Class', y='PC1', data=pc_df, ax=axes[0])
axes[0].set_title('Violin Plots of PC1 Values')
axes[0].set_xlabel('Class')
axes[0].set_ylabel('PC1')

# Violin plot for PC2
sns.violinplot(x='Class', y='PC2', data=pc_df, ax=axes[1])
axes[1].set_title('Violin Plots of PC2 Values')
axes[1].set_xlabel('Class')
axes[1].set_ylabel('PC2')

# Showing the plot values and graphs for No.2 on HW_1
plt.tight_layout()
plt.show()

# BELOW IS THE WORK FOR NO.3 USING T-SNE LIBRARY
tsne = TSNE(n_components=2, random_state=42)
tsne_results = tsne.fit_transform(data)

# made a dataframe for the tsne reduced dimension, our new dataframe
tsne_df = pd.DataFrame(data=tsne_results, columns=['t-SNE 1', 't-SNE 2'])

# purpose here is to add the cancer classes back to our tsne reduced df
tsne_df['Class'] = cancer_Class_2

# making the map to plot our tsne points
plt.figure(figsize=(10, 8))

# inputting the unique elements and keeping it, non-repeating elements
cancer_Class_2 = tsne_df['Class'].unique()

# plotting the points in t-SNEn
colors_t = ['b', 'g', 'r', 'c', 'm']
for i, cancer_Class_2 in enumerate(cancer_Class_2):
    subset = tsne_df[tsne_df['Class'] == cancer_Class_2]
    plt.scatter(subset['t-SNE 1'], subset['t-SNE 2'], c=colors_t[i], label=cancer_Class_2)

plt.xlabel('t-SNE 1')
plt.ylabel('t-SNE 2')
plt.title('Figure No.3: t-SNE of lncRNA Expression Data')
plt.legend()
plt.grid()
plt.show()

# BELOW IS THE WORK FOR NO.4
fig_4, axes_f = plt.subplots(1, 2, figsize=(14, 12))

# BELOW ARE THE VIOLIN PLOT CODE
sns.violinplot(x='Class', y='t-SNE 1', data=tsne_df, ax=axes_f[0])
sns.violinplot(x='Class', y='t-SNE 2', data=tsne_df, ax=axes_f[1])

# Labeling our graphs for readability
axes_f[0].set_ylabel("t-SNE-1 Values")
axes_f[0].set_title("Figure No.4 1st-Violin Plots (t-SNE-1)")

axes_f[1].set_ylabel("t-SNE-2 Values")
axes_f[1].set_title("Figure No.4 2nd-Violin Plots (t-SNE-2)")

# Showing the plot values and graphs for No.4 on HW_1
plt.tight_layout()
plt.show()
